package com.example.pokemonjetpack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokemonjetpack.component.LogoApp


@Composable
fun MainScreen(navController: NavController) {

    val pokemonList = rememberPokemonList()
    Column(horizontalAlignment = Alignment.Start) {
        Button(
            onClick = {

                navController.navigate("LogOutScreen")
            },
            shape = MaterialTheme.shapes.small.copy(
                topStart = CornerSize(0.dp),
                bottomStart = CornerSize(0.dp),
                topEnd = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp)
            )
        ) {
            Text(
                text = "Salir",
                fontSize = 10.sp,
            )
        }
    }
    Column {
        Spacer(modifier = Modifier.height(10.dp))
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

