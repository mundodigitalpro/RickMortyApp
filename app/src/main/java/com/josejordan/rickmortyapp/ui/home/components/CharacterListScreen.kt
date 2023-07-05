package com.josejordan.rickmortyapp.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.josejordan.rickmortyapp.ui.Screen
import com.josejordan.rickmortyapp.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen(navController: NavController) {

    val viewModel: CharacterListViewModel = viewModel()
    val characters = viewModel.characters.observeAsState()

    // Fetch characters when the screen is displayed
    viewModel.fetchAllCharacters()

    // Display character list
    characters.value?.let { list ->
        LazyColumn {
            items(list) { char ->
                Text(text = char.name, modifier = Modifier.clickable {
                    navController.navigate(Screen.CharacterDetail(char.id).route)
                })
                // Add more fields as needed...
            }
        }
    }
}



/*@Composable
fun CharacterListScreen() {
    val viewModel: CharacterListViewModel = viewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value

    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character)
        }
    }
}*/

/*@Composable
fun CharacterListScreen(onCharacterClick: (Int) -> Unit) {
    val viewModel: CharacterListViewModel = viewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value

    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character = character, onItemClick = { onCharacterClick(character.id) })
        }
    }
}*/

