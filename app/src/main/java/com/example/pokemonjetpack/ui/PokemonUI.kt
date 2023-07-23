package com.example.pokemonjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
fun PokemonListItem(pokemon: Pokemon) {
    Row(
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
        Column {
            Text(text = pokemon.name)
            Text(text = "Height: ${pokemon.height}")
            Text(text = "Weight: ${pokemon.weight}")
            Text(text = "id: ${pokemon.id}")
        }
    }
}

@Composable
fun rememberPokemonList(): List<Pokemon> {
    val pokemonList = remember { mutableStateOf(emptyList<Pokemon>()) }
    LaunchedEffect(Unit) {
        fetchDataAndUpdateUI(pokemonList)
    }

    return pokemonList.value
}

suspend fun fetchDataAndUpdateUI(pokemonList: MutableState<List<Pokemon>>) {
    GlobalScope.launch(Dispatchers.IO) {
        val response = fetchPokemonList()
        val updatedList = response.results.map { pokemonResult ->
            val pokemonResponse = fetchPokemon(pokemonResult.url)
            Gson().fromJson(pokemonResponse, Pokemon::class.java)
        }
        pokemonList.value = updatedList
    }
}





