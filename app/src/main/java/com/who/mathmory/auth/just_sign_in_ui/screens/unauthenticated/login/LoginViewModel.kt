package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.who.mathmory.auth.just_sign_in_ui.common.state.ErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.LoginErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.LoginState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.LoginUiEvent
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.emailOrMobileEmptyErrorState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.state.passwordEmptyErrorState
import com.who.mathmory.ui.Routes

/**
 * ViewModel for Login Screen
 */
class LoginViewModel : ViewModel() {

    var loginState = mutableStateOf(LoginState())
        private set

    /**
     * Function called on any login event [LoginUiEvent]
     */
    fun onUiEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {

            // Email/Mobile changed
            is LoginUiEvent.EmailOrMobileChanged -> {
                loginState.value = loginState.value.copy(
                    emailOrMobile = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        emailOrMobileErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailOrMobileEmptyErrorState
                    )
                )
            }

            // Password changed
            is LoginUiEvent.PasswordChanged -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            passwordEmptyErrorState
                    )
                )
            }

            // Submit Login
            is LoginUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    login()
                    //loginState.value = loginState.value.copy(isLoginSuccessful = true)
                }
            }
//            is LoginUiEvent.GoogleSignIn -> {
//                // Perform Google sign-in
//                // Update login state accordingly
//                // For demonstration purposes, let's assume Google sign-in was successful
//                loginState.value = loginState.value.copy(
//                    isLoginSuccessful = true
//                )
//            }
        }
    }

    /**
     * Function to validate inputs
     * Ideally it should be on domain layer (usecase)
     * @return true -> inputs are valid
     * @return false -> inputs are invalid
     */
    private fun validateInputs(): Boolean {
        val emailOrMobileString = loginState.value.emailOrMobile.trim()
        val passwordString = loginState.value.password
        return when {

            // Email/Mobile empty
            emailOrMobileString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        emailOrMobileErrorState = emailOrMobileEmptyErrorState
                    )
                )
                false
            }

            //Password Empty
            passwordString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                loginState.value = loginState.value.copy(errorState = LoginErrorState())
                true
            }
        }
    }

    private fun login(){
        val emailOrMobile = loginState.value.emailOrMobile
        val password = loginState.value.password
        val isEmail = emailOrMobile.contains("@")

        if (isEmail) {
            FirebaseAuth
                .getInstance()
                .signInWithEmailAndPassword(emailOrMobile, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Login successful
                        loginState.value = loginState.value.copy(isLoginSuccessful = true)
                        Log.d(ContentValues.TAG, "Inside_OnCompleteListener")
                        Log.d(ContentValues.TAG, "isSuccessful = ${task.isSuccessful}")
                    } else {
                        // Login failed
                        loginState.value = loginState.value.copy(isLoginSuccessful = false, errorMessage = "Пароль не совпадает.")
                        Log.d(ContentValues.TAG, "Inside_OnCompleteListener")
                        Log.d(ContentValues.TAG, "isSuccessful = ${task.isSuccessful}")
                    }
                }
                .addOnFailureListener {
                    Log.d(ContentValues.TAG, "Inside_OnFailureListener")
                    Log.d(ContentValues.TAG, "Exception ${it.localizedMessage}")
                }
        }
        else
        {
            loginState.value = loginState.value.copy(isLoginSuccessful = false, errorMessage = "Пользователь не найден. Попробуйте зарегистрироваться или войти с помощью почты.")
        }

    }

    fun logout(navController: NavController){
        navController.popBackStack()

        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = AuthStateListener{
            if(it.currentUser == null){
                Log.d(TAG, "Inside logout success")
            }else{
                Log.d(TAG, "Inside logout is not complete")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)
    }

}