package com.example.pokemonjetpack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LogOutScreen(
    navController: NavController
){
   Column(horizontalAlignment = Alignment.Start) {
       Button(
           onClick = {
               navController.popBackStack("LoginScreen",inclusive = true)
               navController.popBackStack("LogOutScreen",inclusive = true)
               navController.popBackStack("MainScreen",inclusive = true)
               navController.navigate("LoginScreen")


           },
           shape = MaterialTheme.shapes.small.copy(
               topStart = CornerSize(0.dp),
               bottomStart = CornerSize(0.dp),
               topEnd = CornerSize(0.dp),
               bottomEnd = CornerSize(0.dp)
           )
       ) {
           Text(
               text = "Cerrar Sesion",
               fontSize = 10.sp,
           )
       }

   }
}