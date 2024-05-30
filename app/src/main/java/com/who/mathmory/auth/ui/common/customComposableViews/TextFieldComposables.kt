package com.who.mathmory.auth.ui.common.customComposableViews

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.who.mathmory.Fonts
import com.who.mathmory.R

/**
 * Password Text Field
 */
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Done
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val focusRequester = remember { FocusRequester() }
    val focusState = remember { mutableStateOf(false) }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label,
                style = TextStyle(
                    fontFamily = Fonts.mulishFontFamily,
                    fontWeight = FontWeight.Black,
                    color = if (isError) Color(0xffb2261e) else Color.Black,
                    fontSize = 15.sp))
        },
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {

                val visibleIconAndText = Pair(
                    first = Icons.Outlined.Lock,
                    second = stringResource(id = R.string.icon_password_visible)
                )

                val hiddenIconAndText = Pair(
                    first = Icons.Outlined.Search,
                    second = stringResource(id = R.string.icon_password_hidden)
                )

                val passwordVisibilityIconAndText =
                    if (isPasswordVisible) visibleIconAndText else hiddenIconAndText

                // Render Icon
                Icon(
                    imageVector = passwordVisibilityIconAndText.first,
                    contentDescription = passwordVisibilityIconAndText.second,
                    tint = Color(0xff333333)
                )
            }
        },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextInputField(text = errorText)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black.copy(alpha = 0.5f),
            unfocusedBorderColor = Color.Black.copy(alpha = 1f),
            cursorColor = colorResource(id = R.color.black),
        ),
    )
}

/**
 * Email Text Field
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Next,
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = Fonts.mulishFontFamily,
                    fontWeight = FontWeight.Black,
                    color = if (isError) Color(0xffb2261e) else Color.Black,
                    fontSize = 15.sp)
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextInputField(text = errorText)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black.copy(alpha = 0.5f),
            unfocusedBorderColor = Color.Black.copy(alpha = 1f),
            cursorColor = colorResource(id = R.color.black),
        ),

    )

}

/**
 * Mobile Number Text Field
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileNumberTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Next
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label,
                style = TextStyle(
                    fontFamily = Fonts.mulishFontFamily,
                    fontWeight = FontWeight.Black,
                    color = if (isError) Color(0xffb2261e) else Color.Black,
                    fontSize = 15.sp))
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = imeAction
        ),
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextInputField(text = errorText)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black.copy(alpha = 0.5f),
            unfocusedBorderColor = Color.Black.copy(alpha = 1f),
            cursorColor = colorResource(id = R.color.black),
        ),
    )

}