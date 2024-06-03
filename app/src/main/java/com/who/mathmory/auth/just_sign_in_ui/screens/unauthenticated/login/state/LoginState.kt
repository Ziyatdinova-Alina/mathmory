package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state

import com.who.mathmory.auth.just_sign_in_ui.common.state.ErrorState

/**
 * Login State holding ui input values
 */
data class LoginState(
    val emailOrMobile: String = "",
    val password: String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful: Boolean = false,
    val errorMessage: String? = null
    //val isGoogleLoginSuccessful: Boolean = false,
)

/**
 * Error state in login holding respective
 * text field validation errors
 */
data class LoginErrorState(
    val emailOrMobileErrorState: ErrorState = ErrorState(),
    val passwordErrorState: ErrorState = ErrorState()
)

