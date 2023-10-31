package com.example.myprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myprojects.Coffee.COmentarios
import com.example.myprojects.Coffee.Portada
import com.example.myprojects.ElSol.Email
import com.example.myprojects.ElSol.Info
import com.example.myprojects.ElSol.Principal
import com.example.myprojects.ui.theme.MyProjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProjectsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination = "MyProjects"){
                        composable("MyProjects") { MyProjects(navController = navController) }
                        composable("Principal") { Principal(navController = navController) }
                        composable("Filled.Email") { Email() }
                        composable("Filled.Info") { Info() }
                        composable("Filled.Build") {  Principal(navController = navController) }
                        composable("Portada") { Portada(navController = navController) }
                        composable(
                            route = "Comentarios/{cafeteriaName}",
                            arguments = listOf(navArgument("cafeteriaName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            COmentarios(backStackEntry.arguments?.getString("cafeteriaName") ?: "", navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProjectsTheme {
        Greeting("Android")
    }
}