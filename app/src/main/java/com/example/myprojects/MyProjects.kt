package com.example.myprojects

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myprojects.ui.theme.FontTitle

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyProjects(navController: NavHostController){

    Scaffold (bottomBar = {
        MyNavigationBar(navController)
    }){
        Row (modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "My Projects", fontSize = 30.sp, fontFamily = FontTitle)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyNavigationBar(navController: NavHostController){
    val items = listOf("CoffeShop", "ElSol")
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(item)},
                icon = { when(item){
                    "CoffeShop" -> Icon(Icons.Filled.AccountBox,contentDescription = item)
                    "ElSol" -> Icon(Icons.Filled.Favorite,contentDescription = item)
                } },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when(selectedItem){
                        0 -> navController.navigate("Portada")
                        1 -> navController.navigate("Principal")
                    }
                },
            )
        }
    }
}
