package com.example.pokemonjetpack.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonjetpack.data.Pokemon
import com.example.pokemonjetpack.data.fetchPokemon
import com.example.pokemonjetpack.data.fetchPokemonList
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val _pokemonList= mutableStateOf(emptyList<Pokemon>())
    val pokemonList: State<List<Pokemon>> =_pokemonList


    //fetch pokemon

    fun  fetchPokemonListVM(){
        viewModelScope.launch(Dispatchers.IO) {
            val response= fetchPokemonList()
            val updateList= response.results.map { pokemonResult ->
                val pokemonResponse= fetchPokemon(pokemonResult.url)
                Gson().fromJson(pokemonResponse,Pokemon::class.java)
            }
            _pokemonList.value=updateList
        }
    }
}