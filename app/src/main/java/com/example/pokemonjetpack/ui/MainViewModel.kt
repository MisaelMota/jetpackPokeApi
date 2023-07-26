package com.example.pokemonjetpack.ui

import android.util.Log
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

    init {
        fetchPokemonListVM()
    }

    //fetch pokemon

    fun  fetchPokemonListVM(){
        viewModelScope.launch(Dispatchers.IO) {
            val response= fetchPokemonList()
            val updateList= response.results.map { pokemonResult ->
                val pokemonResponse= fetchPokemon(pokemonResult.url)
                Gson().fromJson(pokemonResponse,Pokemon::class.java)
            }
            _pokemonList.value=updateList
            Log.d("MainViewModel", "Pokemon List: ${_pokemonList.value}")
        }
    }

    fun getPokemon(id: Int?): Pokemon? {
        Log.d("MainViewModel", "Searching for Pokemon with ID=$id")
        val pokemon = _pokemonList.value.find { it.id == id }
        Log.d("MainViewModel", "Found Pokemon: $pokemon")
        return pokemon
    }


}