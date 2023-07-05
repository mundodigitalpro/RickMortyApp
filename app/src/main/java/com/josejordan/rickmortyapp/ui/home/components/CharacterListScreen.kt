package com.josejordan.rickmortyapp.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.josejordan.rickmortyapp.viewmodel.CharacterListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(navController: NavController, viewModel: CharacterListViewModel = hiltViewModel()) {
    val filteredCharacters = viewModel.filteredCharacters.observeAsState(initial = emptyList()).value

    // Begin with a Column layout so we can put things vertically one after another.
    Column {
        // TextField for the search input at the top
        OutlinedTextField(
            value = viewModel.searchQuery.value ?: "",
            onValueChange = { viewModel.setSearchQuery(it) },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // LazyColumn for the list of characters below
        LazyColumn {
            items(filteredCharacters) { character ->
                CharacterListItem(character) {
                    navController.navigate("character_detail/${it.id}")
                }
            }
        }
    }
}



/*@Composable
fun CharacterListScreen(navController: NavController) {
    val viewModel: CharacterListViewModel = hiltViewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value

    var searchTerm by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = searchTerm,
            onValueChange = { newSearchTerm ->
                searchTerm = newSearchTerm
                viewModel.fetchAllCharacters(searchTerm)
            },
            label = { Text("Search Characters") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn {
            items(characters) { character ->
                CharacterListItem(character) {
                    navController.navigate("character_detail/${it.id}")
                }
            }
        }
    }
}*/


/*
@Composable
fun CharacterListScreen(navController: NavController) {
    val viewModel: CharacterListViewModel = hiltViewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value
    var searchTerm by remember { mutableStateOf("") }


    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character) {
                navController.navigate("character_detail/${it.id}")
            }
        }
    }
}
*/
