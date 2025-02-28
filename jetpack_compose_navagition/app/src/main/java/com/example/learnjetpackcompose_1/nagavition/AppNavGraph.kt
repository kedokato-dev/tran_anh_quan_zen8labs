package com.example.learnjetpackcompose_1.nagavition

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.learnjetpackcompose_1.screens.DetailScreen
import com.example.ui.screens.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Detail.route, arguments = listOf(navArgument("itemId") { type = NavType.StringType })) { backStackEntry ->
            DetailScreen(navController, backStackEntry.arguments?.getString("itemId"))
        }
    }
}
