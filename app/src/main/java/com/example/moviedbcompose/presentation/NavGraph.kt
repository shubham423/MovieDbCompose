package com.example.moviedbcompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviedbcompose.navigation.Screen
import com.example.moviedbcompose.presentation.screens.HomeScreen

@Composable
fun SetupNavGraph(
    startDestination: String,
    navController: NavHostController,
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeRoute(
            navigateToMovieDetail = {

            }
        )
    }

}

fun NavGraphBuilder.homeRoute(
    navigateToMovieDetail: (movieId: String) -> Unit,
) {
    composable(route = Screen.Home.route) {
        HomeScreen(navigateToMovieDetail)
    }
}