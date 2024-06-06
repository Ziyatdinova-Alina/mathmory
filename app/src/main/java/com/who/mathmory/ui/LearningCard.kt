package com.who.mathmory.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.who.mathmory.R

//@Composable
//fun LearningCard(navController: NavController) {
//    var rotated by remember {
//        mutableStateOf(false)
//    }
//    val rotation by animateFloatAsState(
//        targetValue = if (rotated) 180f else 0f,
//        animationSpec = tween(500), label = ""
//    )
//    OutlinedButton(
//        onClick = {
//            rotated = !rotated
//        },
//        colors = ButtonDefaults.buttonColors(
//            containerColor = colorResource(id = R.color.neptune),
//            contentColor = colorResource(id = R.color.black)
//        ),
//        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
//        shape = RoundedCornerShape(2.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp)
//            .graphicsLayer {
//                rotationY = rotation
//                cameraDistance = 8 * density
//            }
//    )
//    {
//        if(!rotated){
//            CardQuestion()
//        }
//        else{
//            CardAnswer(rotation)
//        }
//    }
//}


@SuppressLint("DiscouragedApi")
@Composable
fun CardQuestion(question : String) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(question, "drawable", context.packageName)
    val modifier = when (resourceId) {
        R.drawable.derivative_formula1_question -> Modifier.sizeIn(maxWidth = 30.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula2_question -> Modifier.sizeIn(maxWidth = 50.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula3_question -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula4_question -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 50.dp)
        R.drawable.derivative_formula5_question -> Modifier.sizeIn(maxWidth = 50.dp, maxHeight = 90.dp).offset(x = (-0).dp, y = (0).dp)
        R.drawable.derivative_formula6_question -> Modifier.sizeIn(maxWidth = 55.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula7_question -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula8_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula9_question -> Modifier.sizeIn(maxWidth = 80.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula10_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula11_question -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula12_question -> Modifier.sizeIn(maxWidth = 80.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula13_question -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula14_question -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula15_question -> Modifier.sizeIn(maxWidth = 110.dp, maxHeight = 90.dp)
        R.drawable.derivative_formula16_question -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp)

        R.drawable.integral_formula0_question -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp)
        R.drawable.integral_formula1_question -> Modifier.sizeIn(maxWidth = 40.dp, maxHeight = 90.dp)
        R.drawable.integral_formula2_question -> Modifier.sizeIn(maxWidth = 40.dp, maxHeight = 90.dp)
        R.drawable.integral_formula3_question -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp)
        R.drawable.integral_formula4_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 55.dp)
        R.drawable.integral_formula5_question -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp)
        R.drawable.integral_formula6_question -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp)
        R.drawable.integral_formula7_question -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp)
        R.drawable.integral_formula8_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
        R.drawable.integral_formula9_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
        R.drawable.integral_formula10_question -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp)
        R.drawable.integral_formula11_question -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp)
        R.drawable.integral_formula12_question -> Modifier.sizeIn(maxWidth = 75.dp, maxHeight = 90.dp)
        R.drawable.integral_formula13_question -> Modifier.sizeIn(maxWidth = 110.dp, maxHeight = 90.dp)
        R.drawable.integral_formula14_question -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp)
        R.drawable.integral_formula15_question -> Modifier.sizeIn(maxWidth = 110.dp, maxHeight = 90.dp)
        R.drawable.integral_formula16_question -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp)

        else -> Modifier

    }

    val imageUri = if (resourceId != 0) {
        "android.resource://${context.packageName}/$resourceId"
    } else {
        null
    }

    val painter = rememberAsyncImagePainter(model = imageUri)

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.neptune), shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
            .height(250.dp),
        contentAlignment = Alignment.Center
    )
    {
        Image(painter = painter, contentDescription = question, modifier = modifier)
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun CardAnswer(rotation: Float, answer : String) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(answer, "drawable", context.packageName)

    val modifier = when (resourceId) {
        R.drawable.derivative_formula1_answer -> Modifier.sizeIn(maxWidth = 20.dp, maxHeight = 30.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula2_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 70.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula3_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 60.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula4_answer -> Modifier.sizeIn(maxWidth = 55.dp, maxHeight = 80.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula5_answer -> Modifier.sizeIn(maxWidth = 30.dp, maxHeight = 70.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula6_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula7_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 50.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula8_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula9_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula10_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula11_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula12_answer -> Modifier.sizeIn(maxWidth = 80.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }.offset(x = (-7).dp, y = (-5).dp)
        R.drawable.derivative_formula13_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula14_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula15_answer -> Modifier.sizeIn(maxWidth = 65.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.derivative_formula16_answer -> Modifier.sizeIn(maxWidth = 80.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }.offset(x = (-7).dp, y = (-5).dp)

        R.drawable.integral_formula0_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula1_answer -> Modifier.sizeIn(maxWidth = 50.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula2_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula3_answer -> Modifier.sizeIn(maxWidth = 45.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula4_answer -> Modifier.sizeIn(maxWidth = 50.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula5_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula6_answer -> Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula7_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 50.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula8_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula9_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula10_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula11_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula12_answer -> Modifier.sizeIn(maxWidth = 100.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula13_answer -> Modifier.sizeIn(maxWidth = 70.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula14_answer -> Modifier.sizeIn(maxWidth = 90.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula15_answer -> Modifier.sizeIn(maxWidth = 60.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }
        R.drawable.integral_formula16_answer -> Modifier.sizeIn(maxWidth = 75.dp, maxHeight = 90.dp).graphicsLayer { rotationY = rotation }

        else -> Modifier

    }

    val imageUri = if (resourceId != 0) {
        "android.resource://${context.packageName}/$resourceId"
    } else {
        null
    }

    val painter = rememberAsyncImagePainter(model = imageUri)

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.neptune), shape = RoundedCornerShape(3.dp))
            .fillMaxWidth()
            .height(250.dp),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painter,
            contentDescription = answer,
            modifier = modifier
        )

    }
}






