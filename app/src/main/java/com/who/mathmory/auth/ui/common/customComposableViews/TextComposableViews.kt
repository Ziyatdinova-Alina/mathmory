package com.who.mathmory.auth.ui.common.customComposableViews

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.who.mathmory.Fonts
import com.who.mathmory.R

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = Fonts.mulishFontFamily,
            fontWeight = FontWeight.Black,
            color = Color.Black,
            fontSize = 25.sp,
        ),
        color = colorResource(id = R.color.black)
    )
}

@Composable
fun MediumTitleText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = Fonts.mulishFontFamily,
            fontWeight = FontWeight.Black,
            color = Color.Black,
            fontSize = 20.sp,
        ),
        color = colorResource(id = R.color.black),
        textAlign = textAlign
    )
}

@Composable
fun ErrorTextInputField(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.error
    )
}