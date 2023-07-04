package com.josejordan.rickmortyapp.ui.home.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import com.josejordan.rickmortyapp.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen() {
    val viewModel: CharacterListViewModel = viewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value

    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character)
        }
    }
}


/*@Composable
fun CharacterListScreen() {
    val viewModel: CharacterListViewModel = viewModel()
    val characters = viewModel.characters.value ?: emptyList()

    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character)
        }
    }
}*/
