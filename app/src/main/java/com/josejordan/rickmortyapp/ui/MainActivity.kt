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
                NavHost(navController, startDestination = "character_list") {
                    composable("character_list") {
                        Surface {
                            CharacterListScreen(navController)
                        }
                    }
                    composable("character_detail/{id}") { backStackEntry ->
                        val characterId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                        if (characterId != null) {
                            Surface {
                                CharacterDetailScreen(characterId)
                            }
                        } else {
                            // Handle error, you can redirect to an error screen or the list screen
                            navController.navigate("character_list")
                        }
                    }
                }
            }
        }
    }
}

