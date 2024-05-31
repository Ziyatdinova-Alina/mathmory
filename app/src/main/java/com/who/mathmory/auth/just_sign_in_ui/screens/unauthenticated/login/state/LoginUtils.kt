package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state


import com.who.mathmory.R
import com.who.mathmory.auth.just_sign_in_ui.common.state.ErrorState

val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)