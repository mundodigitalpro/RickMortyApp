package com.josejordan.rickmortyapp.ui.home.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.josejordan.rickmortyapp.viewmodel.CharacterDetailViewModel
import com.josejordan.rickmortyapp.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen(navController: NavController) {
    //val viewModel: CharacterListViewModel = viewModel()
    val viewModel: CharacterListViewModel = hiltViewModel()
    val characters = viewModel.characters.observeAsState(initial = emptyList()).value

    LazyColumn {
        items(characters) { character ->
            CharacterListItem(character) {
                navController.navigate("character_detail/${it.id}")
            }
        }
    }
}
