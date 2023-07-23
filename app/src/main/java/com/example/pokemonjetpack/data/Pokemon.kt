package com.example.pokemonjetpack.data

data class Pokemon(
    val photoUrl: String,
    val name: String,
    val height: String,
    val weight: String
)

data class PokemonListResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)