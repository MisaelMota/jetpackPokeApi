package com.example.pokemonjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.pokemonjetpack.data.Pokemon
import com.example.pokemonjetpack.data.fetchPokemon
import com.example.pokemonjetpack.data.fetchPokemonList
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonListItem(pokemon: Pokemon, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.background)
            .clickable {
                navController.navigate("PokemonDetailScreen/${pokemon.id}")
            }
    ) {
        Image(
            painter = rememberImagePainter(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.id}.png"),
            contentDescription = null,
            modifier = Modifier.size(96.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column() {
            Text(text = pokemon.name)
            Text(text = "Height: ${pokemon.height}")
            Text(text = "Weight: ${pokemon.weight}")
            Text(text = "id: ${pokemon.id}")
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonDetailScreen(pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = rememberImagePainter(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.id}.png"),
            contentDescription = null,
            modifier = Modifier.size(96.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column() {
            Text(text = pokemon.name)
            Text(text = "Height: ${pokemon.height}")
            Text(text = "Weight: ${pokemon.weight}")
            Text(text = "id: ${pokemon.id}")
        }
    }
}





