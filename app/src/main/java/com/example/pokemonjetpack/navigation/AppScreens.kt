package com.example.pokemonjetpack.navigation

sealed class AppScreens(val route:String){
    object LoginScreen: AppScreens("LoginScreen")
    object MainScreen: AppScreens("MainScreen")
    object LogOutScreen: AppScreens("LogOutScreen")
    object PokemonDetailScreen:AppScreens("PokemonDetailScreen/{pokemonId}")
}
