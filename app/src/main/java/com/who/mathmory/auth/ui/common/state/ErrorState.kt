package com.who.mathmory.auth.ui.common.state

import androidx.annotation.StringRes
import com.who.mathmory.R

/**
 * Error state holding values for error ui
 */
data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.empty_string
)