package com.who.mathmory.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.who.mathmory.Fonts
import com.who.mathmory.MainViewModel
import com.who.mathmory.R
import com.who.mathmory.ui.Routes



@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(factory = MainViewModel.factory),
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val bottomPadding = screenHeight * 0.3f
    val itemsList = mainViewModel.itemsList.collectAsState(initial = emptyList())
    Box(modifier = Modifier.background(colorResource(id = R.color.neptune))){    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 40.dp)
        .background(colorResource(id = R.color.neptune))) {
        Column(modifier = Modifier){
            Image(
            painter = rememberAsyncImagePainter(model = R.drawable.main_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 50.dp)
                .height(250.dp)
                .align(Alignment.End)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(modifier = Modifier.padding(bottom = bottomPadding)) {
                Row(modifier = Modifier.clickable {navController.navigate(Routes.derivativeTable)}){
                    Image(
                        painter = rememberAsyncImagePainter(model = R.drawable.main_derivative),
                        contentDescription = "f'",
                        Modifier
                            .height(30.dp)
                            .align(Alignment.Bottom)
                            .padding(bottom = 7.dp, end = 10.dp)
                    )
                    Text(
                        text = "Производные",
                        style = TextStyle(
                            fontFamily = Fonts.mulishFontFamily,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Light,
                            color = colorResource(id = R.color.white)
                        ),
                        modifier = Modifier.align(Alignment.Bottom)
                    )
                    Image(
                        painter = rememberAsyncImagePainter(model = R.drawable.navigation_arrow_white),
                        contentDescription = "right",
                        Modifier
                            .align(Alignment.Bottom)
                            .height(20.dp)
                            .padding(bottom = 6.dp, start = 15.dp)

                    )
                }
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 20.dp, bottom = 8.dp)
                )
                Row(modifier = Modifier.clickable {navController.navigate(Routes.integralTable)}){
                    Image(
                        painter = rememberAsyncImagePainter(model = R.drawable.main_integral),
                        contentDescription = "f'",
                        Modifier
                            .height(30.dp)
                            .align(Alignment.Bottom)
                            .padding(bottom = 7.dp, end = 12.dp)
                    )
                    Text(
                        text = "Интегралы",
                        style = TextStyle(
                            fontFamily = Fonts.mulishFontFamily,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Light,
                            color = colorResource(id = R.color.white)
                        ),
                        modifier = Modifier.align(Alignment.Bottom)
                    )
                    Image(
                        painter = rememberAsyncImagePainter(model = R.drawable.navigation_arrow_white),
                        contentDescription = "right",
                        Modifier
                            .align(Alignment.Bottom)
                            .height(20.dp)
                            .padding(bottom = 6.dp, start = 15.dp)

                    )
                }

            }

        }
        Row(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(bottom = 40.dp)){
            Image(
                painter = painterResource(id = R.drawable.main_settings),
                contentDescription = "settings",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.main_m),
                contentDescription = "m",
                modifier = Modifier.size(25.dp)
            )
        }
    }
    }
}

