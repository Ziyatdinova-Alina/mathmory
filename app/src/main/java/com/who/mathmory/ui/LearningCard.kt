package com.who.mathmory.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.who.mathmory.R

@Composable
fun LearningCard(navController: NavController) {
    var rotated by remember {
        mutableStateOf(false)
    }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500), label = ""
    )
    OutlinedButton(
        onClick = {
            rotated = !rotated
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.neptune),
            contentColor = colorResource(id = R.color.black)
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
        shape = RoundedCornerShape(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
    )
    {
        if(!rotated){
            CardQuestion()
        }
        else{
            CardAnswer(rotation)
        }
    }
}


@Composable
fun CardQuestion() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.neptune), shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
            .height(250.dp),
        contentAlignment = Alignment.Center
    )
    {
        Image(painter = rememberAsyncImagePainter(model = R.drawable.integral_formula12_question), contentDescription = "integral_formula12_question", modifier = Modifier.height(28.dp))

    }
}

@Composable
fun CardAnswer(rotation: Float) {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.neptune), shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
            .height(250.dp),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = rememberAsyncImagePainter(model = R.drawable.integral_formula12_question),
            contentDescription = "integral_formula12_question",
            modifier = Modifier
                .height(28.dp)
                .graphicsLayer {
                    rotationY = rotation
                }
        )

    }
}






