//package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin
//
//import android.app.Activity.RESULT_OK
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.IntentSenderRequest
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//import com.google.android.gms.auth.api.identity.Identity
//import com.who.mathmory.auth.just_sign_in_ui.screens.NavigationRoutes
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.profile.ProfileScreen
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleAuthUiClient
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.SignInViewModel
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.LoginScreen
//
//
//private val googleAuthUiClient by lazy {
//    GoogleAuthUiClient(
//        context: Context,
//        oneTapClient = Identity.getSignInClient(applicationContext)
//    )
//}
//fun NavGraphBuilder.googleGraph(navController: NavController) {
//
//    navigation(
//        route = GoogleNavigationRoutes.GoogleUnauthenticated.GoogleNavigationRoute.route,
//        startDestination = GoogleNavigationRoutes.GoogleUnauthenticated.GoogleRegistration.route
//    ) {
//
//        // Login
//        composable("sign_in") {
//            val viewModel = viewModel<SignInViewModel>()
//            val state by viewModel.state.collectAsStateWithLifecycle()
//
//            LaunchedEffect(key1 = Unit) {
//                if(googleAuthUiClient.getSignedInUser() != null) {
//                    navController.navigate("profile")
//                }
//            }
//
//            val launcher = rememberLauncherForActivityResult(
//                contract = ActivityResultContracts.StartIntentSenderForResult(),
//                onResult = { result ->
//                    if(result.resultCode == RESULT_OK) {
//                        lifecycleScope.launch {
//                            val signInResult = googleAuthUiClient.signInWithIntent(
//                                intent = result.data ?: return@launch
//                            )
//                            viewModel.onSignInResult(signInResult)
//                        }
//                    }
//                }
//            )
//
//            LaunchedEffect(key1 = state.isSignInSuccessful) {
//                if(state.isSignInSuccessful) {
//                    Toast.makeText(
//                        applicationContext,
//                        "Sign in successful",
//                        Toast.LENGTH_LONG
//                    ).show()
//
//                    navController.navigate("profile")
//                    viewModel.resetState()
//                }
//            }
//
//            SignInScreen(
//                state = state,
//                onSignInClick = {
//                    lifecycleScope.launch {
//                        val signInIntentSender = googleAuthUiClient.signIn()
//                        launcher.launch(
//                            IntentSenderRequest.Builder(
//                                signInIntentSender ?: return@launch
//                            ).build()
//                        )
//                    }
//                }
//            )
//        }
//        composable("profile") {
//            ProfileScreen(
//                userData = googleAuthUiClient.getSignedInUser(),
//                onSignOut = {
//                    lifecycleScope.launch {
//                        googleAuthUiClient.signOut()
//                        Toast.makeText(
//                            applicationContext,
//                            "Signed out",
//                            Toast.LENGTH_LONG
//                        ).show()
//
//                        navController.popBackStack()
//                    }
//                }
//            )
//        }
//    }
//}
