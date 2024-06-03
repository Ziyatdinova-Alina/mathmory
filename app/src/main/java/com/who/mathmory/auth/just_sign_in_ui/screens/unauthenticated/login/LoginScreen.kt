package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.who.mathmory.Fonts
import com.who.mathmory.auth.just_sign_in_ui.theme.AppTheme
import com.who.mathmory.auth.just_sign_in_ui.common.customComposableViews.TitleText
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.LoginUiEvent
import com.who.mathmory.R
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleSignInButton

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onNavigateToRegistration: () -> Unit,
    onNavigateToForgotPassword: () -> Unit,
    onNavigateToAuthenticatedRoute: () -> Unit,
) {

    val loginState by remember {
        loginViewModel.loginState
    }

    if (loginState.isLoginSuccessful) {
        /**
         * Navigate to Authenticated navigation route
         * once login is successful
         */
        LaunchedEffect(key1 = true) {
            onNavigateToAuthenticatedRoute.invoke()
        }
    } else {

        // Full Screen Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .background(colorResource(id = R.color.neptune)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Main card Content for Login
            ElevatedCard(
                modifier = Modifier
                    .background(colorResource(id = R.color.neptune))
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.paddingLarge)
                ) {
                Column(
                    modifier = Modifier
                        .background(colorResource(id = R.color.neptune))
                        .padding(horizontal = AppTheme.dimens.paddingLarge)
                        .padding(bottom = AppTheme.dimens.paddingExtraLarge)

                ) {

                    // Login Logo
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 30.dp, end = 130.dp, bottom = 20.dp, start = 130.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = R.drawable.main_m_black)
                            .crossfade(enable = true)
                            .scale(Scale.FILL)
                            .build(),
                        contentDescription = stringResource(id = R.string.login_heading_text)
                    )

                    // Heading Login
                    TitleText(
                        modifier = Modifier
                            .padding(top = AppTheme.dimens.paddingLarge)
                            .background(colorResource(id = R.color.neptune)),
                        text = stringResource(id = R.string.login_heading_text)
                    )

                    // Login Inputs Composable
                    LoginInputs(
                        loginState = loginState,
                        onEmailOrMobileChange = { inputString ->
                            loginViewModel.onUiEvent(
                                loginUiEvent = LoginUiEvent.EmailOrMobileChanged(
                                    inputString
                                )
                            )
                        },
                        onPasswordChange = { inputString ->
                            loginViewModel.onUiEvent(
                                loginUiEvent = LoginUiEvent.PasswordChanged(
                                    inputString
                                )
                            )
                        },
                        onSubmit = {
                            loginViewModel.onUiEvent(loginUiEvent = LoginUiEvent.Submit)
                        },
                        onForgotPasswordClick = onNavigateToForgotPassword
                    )

                }
            }

            // Register Section
            Row(
                modifier = Modifier.padding(AppTheme.dimens.paddingNormal),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Don't have an account?
                Text(text = stringResource(id = R.string.do_not_have_account),
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 17.sp))

                //Register
                Text(
                    modifier = Modifier
                        .padding(start = AppTheme.dimens.paddingExtraSmall)
                        .clickable {
                            onNavigateToRegistration.invoke()
                        },
                    text = stringResource(id = R.string.register),
                    color = colorResource(id = R.color.white),
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 17.sp)
                )
            }
            Row(
                modifier = Modifier.padding(AppTheme.dimens.paddingNormal),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                // Don't have an account?
                Text(text = stringResource(id = R.string.or),
                    style = TextStyle(
                        fontFamily = Fonts.mulishFontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color.Black,
                        fontSize = 17.sp))
            }

            GoogleSignInButton()

        }

    }
    if (loginState.errorMessage != null) {
        Text(
            text = loginState.errorMessage!!,
            color = Color(0xffb2261e),
            modifier = Modifier.padding(8.dp)
        )
    }

}
