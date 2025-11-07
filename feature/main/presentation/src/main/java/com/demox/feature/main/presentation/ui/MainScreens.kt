package com.demox.feature.main.presentation.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.demox.feature.main.presentation.ui.main.MainScreen


sealed class MainScreens(
    val route: String,
) {
    object MainScreen : MainScreens("main_screen")
}

fun NavGraphBuilder.mainNavScreens(navController: NavHostController) {
    composable(MainScreens.MainScreen.route) {
        MainScreen(
            navController
        )
    }
}