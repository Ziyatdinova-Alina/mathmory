package com.who.mathmory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.google.android.gms.auth.api.identity.Identity
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.GoogleAuthUiClient
import com.who.mathmory.auth.just_sign_in_ui.screens.NavigationRoutes
import com.who.mathmory.auth.just_sign_in_ui.screens.authenticatedGraph
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.sign_in.SignInViewModel
//import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin.googleGraph
import com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticatedGraph
import com.who.mathmory.data.Derivatives
import com.who.mathmory.data.Integrals
import com.who.mathmory.data.MathDatabase
import com.who.mathmory.ui.derivative.DerivativeLearning
import com.who.mathmory.ui.derivative.DerivativeTable
import com.who.mathmory.ui.integral.IntegralTable
import com.who.mathmory.ui.MainScreen
import com.who.mathmory.ui.Routes
import com.who.mathmory.ui.integral.IntegralLearning
import com.who.mathmory.ui.theme.MathmoryTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier


class MainActivity : ComponentActivity() {
    private lateinit var database : MathDatabase

    // CoroutineScope для асинхронных операций с базой данных


//
//
//
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
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        database = MathDatabase(this@MainActivity)
        scope.launch {
            if (database.isDerivativeDatabaseEmpty()) {
                val initData = listOf(
                    Derivatives("1", 0, "derivative_formula1_question", "derivative_formula1_answer"),
                    Derivatives("2", 0, "derivative_formula2_question", "derivative_formula2_answer"),
                    Derivatives("3", 0, "derivative_formula3_question", "derivative_formula3_answer"),
                    Derivatives("4", 0, "derivative_formula4_question", "derivative_formula4_answer"),
                    Derivatives("5", 0, "derivative_formula5_question", "derivative_formula5_answer"),
                    Derivatives("6", 0, "derivative_formula6_question", "derivative_formula6_answer"),
                    Derivatives("7", 0, "derivative_formula7_question", "derivative_formula7_answer"),
                    Derivatives("8", 0, "derivative_formula8_question", "derivative_formula8_answer"),
                    Derivatives("9", 0, "derivative_formula9_question", "derivative_formula9_answer"),
                    Derivatives("10", 0, "derivative_formula10_question", "derivative_formula10_answer"),
                    Derivatives("11", 0, "derivative_formula11_question", "derivative_formula11_answer"),
                    Derivatives("12", 0, "derivative_formula12_question", "derivative_formula12_answer"),
                    Derivatives("13", 0, "derivative_formula13_question", "derivative_formula13_answer"),
                    Derivatives("14", 0, "derivative_formula14_question", "derivative_formula14_answer"),
                    Derivatives("15", 0, "derivative_formula15_question", "derivative_formula15_answer"),
                    Derivatives("16", 0, "derivative_formula16_question", "derivative_formula16_answer")
                )
                database.insertAllDerivative(initData)
            }

            if (database.isIntegralsDatabaseEmpty()) {
                    val initData = listOf(
                    Integrals("0", 0, "integral_formula0_question", "integral_formula0_answer"),
                    Integrals("1", 0, "integral_formula1_question", "integral_formula1_answer"),
                    Integrals("2", 0, "integral_formula2_question", "integral_formula2_answer"),
                    Integrals("3", 0, "integral_formula3_question", "integral_formula3_answer"),
                    Integrals("4", 0, "integral_formula4_question", "integral_formula4_answer"),
                    Integrals("5", 0, "integral_formula5_question", "integral_formula5_answer"),
                    Integrals("6", 0, "integral_formula6_question", "integral_formula6_answer"),
                    Integrals("7", 0, "integral_formula7_question", "integral_formula7_answer"),
                    Integrals("8", 0, "integral_formula8_question", "integral_formula8_answer"),
                    Integrals("9", 0, "integral_formula9_question", "integral_formula9_answer"),
                    Integrals("10", 0, "integral_formula10_question", "integral_formula10_answer"),
                    Integrals("11", 0, "integral_formula11_question", "integral_formula11_answer"),
                    Integrals("12", 0, "integral_formula12_question", "integral_formula12_answer"),
                    Integrals("13", 0, "integral_formula13_question", "integral_formula13_answer"),
                    Integrals("14", 0, "integral_formula14_question", "integral_formula14_answer"),
                    Integrals("15", 0, "integral_formula15_question", "integral_formula15_answer"),
                    Integrals("16", 0, "integral_formula16_question", "integral_formula16_answer")
                )
                database.insertAllIntegrals(initData)
            }
        }

        installSplashScreen()
        setContent {
            MathmoryTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoutes.Unauthenticated.NavigationRoute.route,

                    enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(700))},
                    exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(700)) },
                    popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(700)) },
                    popExitTransition = {slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(700))} ,

                    builder ={

                        unauthenticatedGraph(navController = navController,)

                        authenticatedGraph(navController = navController)


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
                        composable(Routes.integralLearning){
                            IntegralLearning(navController)
                        }

                    }
                )
            }
        }
    }
}

