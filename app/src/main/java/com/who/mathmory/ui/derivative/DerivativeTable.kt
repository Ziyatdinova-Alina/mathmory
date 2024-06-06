package com.who.mathmory.ui.derivative

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.who.mathmory.ui.Routes

@Composable
fun DerivativeTable(navController: NavController) {
    Column(
        modifier= Modifier
            .background(colorResource(id = R.color.neptune))
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 40.dp),
    )
    {
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
                    .clickable {navController.popBackStack()}
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Производные",
                style = TextStyle(
                    fontFamily = Fonts.mulishFontFamily,
                    fontWeight = FontWeight.Black,
                    color = Color.Black,
                    fontSize = 25.sp,
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = rememberAsyncImagePainter(model = R.drawable.navigation_options),
                contentDescription = "menu",
                modifier = Modifier
                    .height(25.dp)
                    .align(Alignment.CenterVertically)
                    .clickable{navController.navigate(Routes.profileScreen)}
            )
        }
        HorizontalDivider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
            items(1){
                DerivativeList()
            }
        }
        OutlinedButton(
            onClick = {
                navController.navigate(Routes.derivativeLearning)
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
                .shadow(3.dp)

        ) {
            Row {
                Text("изучать",
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 23.sp)
                )
                Image(
                    painter = rememberAsyncImagePainter(model = R.drawable.navigation_arrow_black),
                    contentDescription = "integralCards",
                    modifier = Modifier
                        .height(20.dp)
                        .align(Alignment.CenterVertically)
                        .padding(top = 5.dp, start = 10.dp)
                )
            }
        }
    }
}