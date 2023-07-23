package com.example.pokemonjetpack.data

import okhttp3.*
import com.google.gson.Gson

suspend fun fetchPokemonList(): PokemonListResponse {
    val url = "https://pokeapi.co/api/v2/pokemon"
    val request = Request.Builder()
        .url(url)
        .build()

    val client = OkHttpClient()
    val response = client.newCall(request).execute()
    val responseBody = response.body?.string()

    return Gson().fromJson(responseBody, PokemonListResponse::class.java)
}

suspend fun fetchPokemon(url: String): String {
    val request = Request.Builder()
        .url(url)
        .build()

    val client = OkHttpClient()
    val response = client.newCall(request).execute()
    return response.body?.string() ?: ""
}

