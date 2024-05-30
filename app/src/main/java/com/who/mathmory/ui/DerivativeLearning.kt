package com.who.mathmory.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.who.mathmory.Fonts
import com.who.mathmory.R

@Composable
fun DerivativeLearning(navController: NavController) {
    var rotated by remember {
        mutableStateOf(false)
    }
    var isAnswerShown by remember { mutableStateOf(false) }
    var isReactionAgain by remember { mutableStateOf(false) }
    var isReactionHard by remember { mutableStateOf(false) }
    var isReactionOkay by remember { mutableStateOf(false) }
    var isReactionEasy by remember { mutableStateOf(false) }




    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500), label = ""
    )
    Column(
        modifier= Modifier
            .background(colorResource(id = R.color.neptune))
            .fillMaxSize()

    )
    {
        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 40.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Image(
                    painter = rememberAsyncImagePainter(model = R.drawable.navigation_arrow_black),
                    contentDescription = "back",
                    modifier = Modifier
                        .height(25.dp)
                        .graphicsLayer(rotationZ = 180f)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "1",
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 25.sp,
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "/",
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 3.dp, end = 1.dp, start = 1.dp)
                )
                Text(
                    text = "31",
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 20.sp,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = rememberAsyncImagePainter(model = R.drawable.navigation_options),
                    contentDescription = "menu",
                    modifier = Modifier
                        .height(25.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 8.dp)
            )



        }




        //REACTION


        Box()
        {



            //AGAIN



            if (isReactionAgain) {
                Row(modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp))
                {
                    OutlinedButton(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .weight(0.2f),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.again)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Icon(
                                    painter = rememberAsyncImagePainter(model = R.drawable.reaction_again),
                                    contentDescription = "menu",
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            else if (isReactionHard) {
                Row(modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp))
                {
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedButton(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .weight(0.2f),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.hard)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Icon(
                                    painter = rememberAsyncImagePainter(model = R.drawable.reaction_hard),
                                    contentDescription = "menu",
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                        }
                    }
                }
            }
            else if (isReactionOkay) {
                Row(modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp))
                {
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedButton(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .weight(0.2f),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.yellow)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Icon(
                                    painter = rememberAsyncImagePainter(model = R.drawable.reaction_okay),
                                    contentDescription = "menu",
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                        }
                    }
                }
            }
            else if (isReactionEasy) {
                Row(modifier = Modifier.padding(vertical = 25.dp, horizontal = 20.dp))
                {
                    Spacer(modifier = Modifier.weight(1f))
                    OutlinedButton(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .weight(0.2f),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.easy)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Icon(
                                    painter = rememberAsyncImagePainter(model = R.drawable.reaction_easy),
                                    contentDescription = "menu",
                                    modifier = Modifier.size(30.dp)
                                )

                            }
                        }
                    }
                }
            }
            else
            {
                Column(modifier = Modifier.height(110.dp))
                {
                }
            }
        }




        //CARD



        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 40.dp)) {
            OutlinedButton(
                onClick = {
                    if(isAnswerShown){
                        rotated = !rotated
                    }
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
                    .shadow(3.dp)
            )
            {
                if(!rotated){
                    CardQuestion()
                }
                if(isAnswerShown){
                    CardAnswer(rotation)
                }
            }
        }




        //BUTTONS




        Spacer(modifier = Modifier.weight(1f))
        Box()
        {
            if (isAnswerShown) {
                Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp))
                {



                    //AGAIN



                    OutlinedButton(
                        onClick = {
                            isReactionAgain = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(70.dp)
                            .weight(0.2f)
                            .padding(top = 16.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.again)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Text(
                                    "Ещё раз",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 17.sp
                                    )
                                )
                                Text(
                                    "<1м",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.02f))




                    //HARD



                    OutlinedButton(
                        onClick = {
                            isReactionHard = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(70.dp)
                            .weight(0.2f)
                            .padding(top = 16.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.hard)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Text(
                                    "Сложно",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 17.sp
                                    )
                                )
                                Text(
                                    "8м",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.02f))




                    //OKAY



                    OutlinedButton(
                        onClick = {
                            isReactionOkay = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(70.dp)
                            .weight(0.2f)
                            .padding(top = 16.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.yellow)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Text(
                                    "Норм",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 17.sp
                                    )
                                )
                                Text(
                                    "15м",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.02f))


                    //EASY



                    OutlinedButton(
                        onClick = {
                                  isReactionEasy = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .height(70.dp)
                            .weight(0.2f)
                            .padding(top = 16.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.border(BorderStroke(2.dp, colorResource(id = R.color.easy)))){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()) {
                                Text(
                                    "Легко",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 17.sp
                                    )
                                )
                                Text(
                                    "4д",
                                    style = TextStyle(
                                        fontFamily = Fonts.mulishFontFamily,
                                        fontWeight = FontWeight.Black,
                                        color = Color.Black,
                                        fontSize = 12.sp
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.02f))
                }
            }
            else
            {
                Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 40.dp)) {
                    OutlinedButton(
                        onClick = {
                            rotated = !rotated
                            isAnswerShown = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.neptune),
                            contentColor = colorResource(id = R.color.black)
                        ),
                        border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(top = 16.dp)
                    ) {
                        Row {
                            Text("Показать ответ",
                                style = TextStyle(
                                    fontFamily = Fonts.mulishFontFamily,
                                    fontWeight = FontWeight.Black,
                                    color = Color.Black,
                                    fontSize = 22.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}