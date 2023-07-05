package com.josejordan.rickmortyapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.josejordan.rickmortyapp.ui.detail.components.CharacterDetailScreen
import com.josejordan.rickmortyapp.ui.home.components.CharacterListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.CharacterList.route) {
                    composable(Screen.CharacterList.route) {
                        CharacterListScreen(navController)
                    }
                    composable("CharacterDetail/{characterId}") { backStackEntry ->
                        CharacterDetailScreen(backStackEntry.arguments?.getInt("characterId")!!)
                    }
                }
            }
        }
    }
}



/*@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    CharacterListScreen()
                }
            }
        }
    }
}*/

/*@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    CharacterListScreen(onCharacterClick = { id ->
                        navController.navigate("detail/$id")
                    })
                }
                composable("detail/{id}") { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                    characterId?.let {
                        CharacterDetailScreen(characterId = it)
                    }
                }
            }
        }
    }
}*/

