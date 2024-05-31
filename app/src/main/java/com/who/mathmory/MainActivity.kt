package com.who.mathmory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleAuthUiClient
import com.who.mathmory.auth.just_sign_in_ui.screens.NavigationRoutes
import com.who.mathmory.auth.just_sign_in_ui.screens.authenticatedGraph
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.googleGraph
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleRegistration
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleSignInButton
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.SignInState
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.login.LoginScreen
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticatedGraph
import com.who.mathmory.ui.DerivativeLearning
import com.who.mathmory.ui.DerivativeTable
import com.who.mathmory.ui.IntegralTable
import com.who.mathmory.ui.MainScreen
import com.who.mathmory.ui.Routes
import com.who.mathmory.ui.theme.MathmoryTheme


class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MathmoryTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "sign_in") {
//                        composable("sign_in") {
//                            val viewModel = viewModel<SignInViewModel>()
//                            val state by viewModel.state.collectAsStateWithLifecycle()
//
//                            LaunchedEffect(key1 = Unit) {
//                                if(googleAuthUiClient.getSignedInUser() != null) {
//                                    navController.navigate("profile")
//                                }
//                            }
//
//                            val launcher = rememberLauncherForActivityResult(
//                                contract = ActivityResultContracts.StartIntentSenderForResult(),
//                                onResult = { result ->
//                                    if(result.resultCode == RESULT_OK) {
//                                        lifecycleScope.launch {
//                                            val signInResult = googleAuthUiClient.signInWithIntent(
//                                                intent = result.data ?: return@launch
//                                            )
//                                            viewModel.onSignInResult(signInResult)
//                                        }
//                                    }
//                                }
//                            )
//
//                            LaunchedEffect(key1 = state.isSignInSuccessful) {
//                                if(state.isSignInSuccessful) {
//                                    Toast.makeText(
//                                        applicationContext,
//                                        "Sign in successful",
//                                        Toast.LENGTH_LONG
//                                    ).show()
//
//                                    navController.navigate("profile")
//                                    viewModel.resetState()
//                                }
//                            }
//
//                            SignInScreen(
//                                state = state,
//                                onSignInClick = {
//                                    lifecycleScope.launch {
//                                        val signInIntentSender = googleAuthUiClient.signIn()
//                                        launcher.launch(
//                                            IntentSenderRequest.Builder(
//                                                signInIntentSender ?: return@launch
//                                            ).build()
//                                        )
//                                    }
//                                }
//                            )
//                        }
//                        composable("profile") {
//                            ProfileScreen(
//                                userData = googleAuthUiClient.getSignedInUser(),
//                                onSignOut = {
//                                    lifecycleScope.launch {
//                                        googleAuthUiClient.signOut()
//                                        Toast.makeText(
//                                            applicationContext,
//                                            "Signed out",
//                                            Toast.LENGTH_LONG
//                                        ).show()
//
//                                        navController.popBackStack()
//                                    }
//                                }
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MathmoryTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoutes.Unauthenticated.NavigationRoute.route,//Routes.googleSignInButton,//

                    enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(700))},
                    exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(700)) },
                    popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(700)) },
                    popExitTransition = {slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(700))} ,

                    builder ={
                        // Add unauthenticated user flow screens
                        unauthenticatedGraph(navController = navController)

                        // Add authenticated user flow screens
                        authenticatedGraph(navController = navController)

                        //googleGraph(navController = navController)

                        composable(Routes.mainScreen){
                            MainScreen(navController = navController)
                        }
                        composable(Routes.derivativeTable){
                            DerivativeTable(navController)
                        }
                        composable(Routes.integralTable){
                            IntegralTable(navController)
                        }

                        composable(Routes.derivativeLearning){
                            DerivativeLearning(navController)
                        }


                    }
                )
            }
        }
    }
}

