package com.example.pokemonjetpack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemonjetpack.component.LogoApp


@Composable
fun MainScreen(navController: NavController) {

    val pokemonList = rememberPokemonList()

    Column {
        LogoApp()
        Spacer(modifier = Modifier.height(26.dp))
        if (pokemonList.isNotEmpty()) {
            LazyColumn {
                items(pokemonList) { pokemon ->
                    PokemonListItem(pokemon)
                }
            }
        } else {
            Text(text = "Loading...")
        }
    }
}

