package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.who.mathmory.auth.just_sign_in_ui.common.state.ErrorState
import com.jodhpurtechies.composelogin.ui.screens.unauthenticated.registration.state.*
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.RegistrationErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.RegistrationState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.confirmPasswordEmptyErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.emailEmptyErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.mobileNumberEmptyErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.passwordEmptyErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.registration.state.passwordMismatchErrorState

class RegistrationViewModel : ViewModel() {

    var registrationState = mutableStateOf(RegistrationState())
        private set

    /**
     * Function called on any login event [RegistrationUiEvent]
     */
    fun onUiEvent(registrationUiEvent: RegistrationUiEvent) {
        when (registrationUiEvent) {

            // Email id changed event
            is RegistrationUiEvent.EmailChanged -> {
                registrationState.value = registrationState.value.copy(
                    emailId = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        emailIdErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            // Email id empty state
                            emailEmptyErrorState
                        } else {
                            // Valid state
                            ErrorState()
                        }

                    )
                )
            }

            // Mobile Number changed event
            is RegistrationUiEvent.MobileNumberChanged -> {
                registrationState.value = registrationState.value.copy(
                    mobileNumber = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        mobileNumberErrorState = if (registrationUiEvent.inputValue.trim()
                                .isEmpty()
                        ) {
                            // Mobile Number Empty state
                            mobileNumberEmptyErrorState
                        } else {
                            // Valid state
                            ErrorState()
                        }

                    )
                )
            }

            // Password changed event
            is RegistrationUiEvent.PasswordChanged -> {
                registrationState.value = registrationState.value.copy(
                    password = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        passwordErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            // Password Empty state
                            passwordEmptyErrorState
                        } else {
                            // Valid state
                            ErrorState()
                        }

                    )
                )
            }

            // Confirm Password changed event
            is RegistrationUiEvent.ConfirmPasswordChanged -> {
                registrationState.value = registrationState.value.copy(
                    confirmPassword = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        confirmPasswordErrorState = when {

                            // Empty state of confirm password
                            registrationUiEvent.inputValue.trim().isEmpty() -> {
                                confirmPasswordEmptyErrorState
                            }

                            // Password is different than the confirm password
                            registrationState.value.password.trim() != registrationUiEvent.inputValue -> {
                                passwordMismatchErrorState
                            }

                            // Valid state
                            else -> ErrorState()
                        }
                    )
                )
            }


            // Submit Registration event
            is RegistrationUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    createUserInFirebase(
                        email = registrationState.value.emailId,
                        phone = registrationState.value.mobileNumber,
                        password = registrationState.value.password,
                        confirmPassword = registrationState.value.confirmPassword
                    )
                    //registrationState.value =
                        //registrationState.value.copy(isRegistrationSuccessful = true)
                }
            }
        }
    }

    /**
     * Function to validate inputs
     * Ideally it should be on domain layer (usecase)
     * @return true -> inputs are valid
     * @return false -> inputs are invalid
     */
    private fun validateInputs(): Boolean {
        val emailString = registrationState.value.emailId.trim()
        val mobileNumberString = registrationState.value.mobileNumber.trim()
        val passwordString = registrationState.value.password.trim()
        val confirmPasswordString = registrationState.value.confirmPassword.trim()

        return when {

            // Email empty
            emailString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        emailIdErrorState = emailEmptyErrorState
                    )
                )
                false
            }

            //Mobile Number Empty
            mobileNumberString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        mobileNumberErrorState = mobileNumberEmptyErrorState
                    )
                )
                false
            }

            //Password Empty
            passwordString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }

            //Confirm Password Empty
            confirmPasswordString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        confirmPasswordErrorState = confirmPasswordEmptyErrorState
                    )
                )
                false
            }

            // Password and Confirm Password are different
            passwordString != confirmPasswordString -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        confirmPasswordErrorState = passwordMismatchErrorState
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                registrationState.value =
                    registrationState.value.copy(errorState = RegistrationErrorState())
                true
            }
        }
    }

    private fun createUserInFirebase(email:String, phone: String, password:String, confirmPassword:String){
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                registrationState.value = registrationState.value.copy(isRegistrationSuccessful = true)
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")
            }
            .addOnFailureListener{
                registrationState.value = registrationState.value.copy(isRegistrationSuccessful = false, errorMessage = "Регистрация не произошла.")

                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception ${it.localizedMessage}")

            }
    }

}