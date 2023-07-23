package com.example.pokemonjetpack.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogOutScreen(
    navController: NavController
){
   Scaffold{
       LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight()
               .padding(0.dp,120.dp,0.dp,0.dp)
       ) {
           item{
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
                       fontSize = 25.sp,
                   )
               }
           }

       }
   }
}