package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?
)