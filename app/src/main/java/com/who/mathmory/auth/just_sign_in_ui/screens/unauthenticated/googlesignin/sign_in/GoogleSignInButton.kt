package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState
import com.who.mathmory.Fonts
import com.who.mathmory.R
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.LoginState

@Composable
fun GoogleSignInButton(
){
    val state = rememberOneTapSignInState()
    OneTapSignInWithGoogle(
        state = state,
        clientId = "225267200683-aoap3sujmplaskm17u5kj98bulm4fs9e.apps.googleusercontent.com",
        onTokenIdReceived = { tokenId ->
            Log.d("LOG", tokenId)
        },
        onDialogDismissed = { message ->
            Log.d("LOG", message)
        }
    )
    //Google Register
    Button(
        onClick = {
            state.open()
        },
        modifier = Modifier
            .wrapContentWidth()
            .padding(top=0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.neptune)
        ),
    )
    {
        Text(
            text = stringResource(id = R.string.use_google_account),
            color = colorResource(id = R.color.white),
            style = TextStyle(
                fontFamily = Fonts.mulishFontFamily,
                fontWeight = FontWeight.Black,
                color = Color.Black,
                fontSize = 17.sp
            )
        )
    }
}