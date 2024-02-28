package com.example.mobilelearningapp.ui.navigation

import com.example.mobilelearningapp.ui.screens.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilelearningapp.ui.screens.RegisterScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Route.SplashScreen.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
            composable(route = Route.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(route = Route.RegisterScreen.route) {
                RegisterScreen()
            }
        }
    }
