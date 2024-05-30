package com.who.mathmory.auth.ui.screens.unauthenticated.login.state


import com.who.mathmory.R
import com.who.mathmory.auth.ui.common.state.ErrorState

val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)