package com.example.pokemonjetpack.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonjetpack.ui.LogOutScreen
import com.example.pokemonjetpack.ui.LoginScreen
import com.example.pokemonjetpack.ui.MainScreen
import com.example.pokemonjetpack.ui.MainViewModel
import com.example.pokemonjetpack.ui.PokemonDetailScreen

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(AppScreens.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(AppScreens.MainScreen.route){
            val viewModel: MainViewModel = viewModel()
            MainScreen(navController=navController,viewModel=viewModel)
        }
        composable(AppScreens.PokemonDetailScreen.route){ navBackStackEntry ->
            val viewModel: MainViewModel = viewModel()
            val pokemonIdString = navBackStackEntry.arguments?.getString("pokemonId")
            // convert the pokemonId string to an integer
            val pokemonId = pokemonIdString?.toIntOrNull()
            val pokemon = viewModel.getPokemon(pokemonId)
            if (pokemon != null) {
                PokemonDetailScreen(pokemon)
            } else {
                Text("Loading...")
            }
        }
        composable(AppScreens.LogOutScreen.route){
            LogOutScreen(navController=navController)
        }
    }
}