package com.example.mobilelearningapp.ui.navigation

sealed class Route(
    val route: String
) {
    data object SplashScreen : Route(route="splashScreen")
    data object RegisterScreen : Route(route="registerScreen")
    data object HomeScreen : Route(route="homeScreen")
    data object LoginScreen : Route(route="loginScreen")
}