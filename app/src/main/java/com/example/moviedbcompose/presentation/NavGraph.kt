package com.example.moviedbcompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.moviedbcompose.navigation.Screen
import com.example.moviedbcompose.presentation.screens.home.HomeScreen
import com.example.moviedbcompose.presentation.screens.home.HomeVIewModel

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

            },
            onCategoryClicked = {

            }
        )
    }

}

fun NavGraphBuilder.homeRoute(
    navigateToMovieDetail: (movieId: String) -> Unit,
    onCategoryClicked: (category: String) -> Unit,
) {
    composable(route = Screen.Home.route) {
        val homeViewModel: HomeVIewModel = hiltViewModel()
        val popularMovies = homeViewModel.popularMovies.value.collectAsLazyPagingItems()
        val genres by homeViewModel.genres.collectAsState()

        HomeScreen(navigateToMovieDetail, popularMovies, genres,onCategoryClicked)
    }
}