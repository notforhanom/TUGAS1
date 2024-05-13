package com.example.rizzkyy.navigation


sealed class Screen (val route: String){
        data object Home : Screen("home")
        data object Gallery: Screen("gallery")
        data object About: Screen("About")
        data object Detail: Screen("detail_mentors")
    }
