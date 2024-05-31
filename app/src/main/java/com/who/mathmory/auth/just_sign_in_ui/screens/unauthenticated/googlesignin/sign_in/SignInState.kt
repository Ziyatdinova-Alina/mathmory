package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)