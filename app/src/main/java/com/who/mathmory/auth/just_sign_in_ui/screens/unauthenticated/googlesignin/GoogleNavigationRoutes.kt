package com.who.mathmory.auth.just_sign_in_ui.screens.unauthenticated.googlesignin

sealed class GoogleNavigationRoutes {

    // Unauthenticated Routes
    sealed class GoogleUnauthenticated(val route: String) : GoogleNavigationRoutes() {
        object GoogleNavigationRoute : GoogleUnauthenticated(route = "google_unauthenticated")
        object GoogleRegistration : GoogleUnauthenticated(route = "google_registration")

    }

}