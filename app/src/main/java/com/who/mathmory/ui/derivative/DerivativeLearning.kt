package com.who.mathmory.ui.derivative

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.who.mathmory.Fonts
import com.who.mathmory.R
import com.who.mathmory.data.Derivatives
import com.who.mathmory.data.MathDatabase
import com.who.mathmory.data.Reaction
import com.who.mathmory.ui.CardAnswer
import com.who.mathmory.ui.CardQuestion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun DerivativeLearning(navController: NavController) {
    var rotated by remember {
        mutableStateOf(false)
    }
    var isAnswerShown by remember { mutableStateOf(false) }
    var currentReaction by remember { mutableStateOf(Reaction.NONE) }

    val context = LocalContext.current
    val database = MathDatabase(context)

    var questions by remember { mutableStateOf<List<Derivatives>>(emptyList()) }
    var currentIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        questions = database.getDerivativesBeforeTimestamp(System.currentTimeMillis())
        if(questions.isEmpty())
        {
            withContext(Dispatchers.Main) {
                navController.popBackStack()
            }
        }
    }


    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500), label = ""
    )

    fun onNewCard() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            ++currentIndex
            isAnswerShown = false
            rotated = false
            currentReaction = Reaction.NONE
        }
    }

    fun setTimeForCurrentCard(minutes : Long){
        CoroutineScope(Dispatchers.Main).launch {
            val millis = minutes * 60 * 1000
            database.updateTimestampForDerivative(questions[currentIndex].question,
                System.currentTimeMillis() + millis)
        }
    }

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
                    text = (currentIndex + 1).toString(), //"1"
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
                    text = questions.size.toString(), // "31"
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

            when(currentReaction)
            {
                Reaction.NONE->{
                    Row(modifier = Modifier.padding(top = 85.dp)){}

                }
                Reaction.AGAIN->{
                    Row(modifier = Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp))
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
                Reaction.HARD->{
                    Row(modifier = Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp))
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
                Reaction.OKAY->{
                    Row(modifier = Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp))
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
                Reaction.EASY->{
                    Row(modifier = Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp))
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

            }

        }




        //CARD

        Column(modifier = Modifier.padding( start = 40.dp, end = 40.dp)) {
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
                if(currentIndex >= questions.size && questions.isNotEmpty())
                {
                    navController.popBackStack()
                }
                else{
                    if(!rotated){
                        if(questions.isNotEmpty())
                        {
                            val questionForCard = questions[currentIndex].question
                            CardQuestion(questionForCard)
                        }

                    }
                    if(isAnswerShown){
                        if(questions.isNotEmpty())
                        {
                            val answerForCard = questions[currentIndex].answer
                            CardAnswer(rotation, answerForCard)
                        }

                    }
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
                            currentReaction = Reaction.AGAIN
                            setTimeForCurrentCard(1)
                            onNewCard()
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
                            currentReaction = Reaction.HARD
                            setTimeForCurrentCard(8)
                            onNewCard()
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
                            currentReaction = Reaction.OKAY
                            setTimeForCurrentCard(15)
                            onNewCard()
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
                            currentReaction = Reaction.EASY
                            setTimeForCurrentCard(5760)
                            onNewCard()
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