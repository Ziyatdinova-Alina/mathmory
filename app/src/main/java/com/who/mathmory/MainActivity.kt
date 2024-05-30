package com.who.mathmory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.who.mathmory.auth.ui.screens.NavigationRoutes
import com.who.mathmory.auth.ui.screens.authenticatedGraph
import com.who.mathmory.auth.ui.screens.unauthenticatedGraph
import com.who.mathmory.data.MainDb
import com.who.mathmory.ui.DerivativeLearning
import com.who.mathmory.ui.DerivativeTable
import com.who.mathmory.ui.IntegralTable
import com.who.mathmory.ui.MainScreen
import com.who.mathmory.ui.Routes
import com.who.mathmory.ui.theme.MathmoryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

                    // Add unauthenticated user flow screens
                    unauthenticatedGraph(navController = navController)

                    // Add authenticated user flow screens
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

                } )
            }
        }
    }
}

