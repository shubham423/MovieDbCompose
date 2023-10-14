package com.example.moviedbcompose.navigation

import com.example.moviedbcompose.utils.Constants.MOVIE_ID_KEY

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen?$MOVIE_ID_KEY=$MOVIE_ID_KEY") {
        fun passMovieId(movieId: String) =
            "detail_screen?$MOVIE_ID_KEY=$movieId"
    }
}
