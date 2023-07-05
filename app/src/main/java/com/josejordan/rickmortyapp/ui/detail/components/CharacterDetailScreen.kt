package com.josejordan.rickmortyapp.ui.detail.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josejordan.rickmortyapp.viewmodel.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(characterId: Int) {
    val viewModel: CharacterDetailViewModel = viewModel()
    val character = viewModel.character.observeAsState()

    // Fetch character when the screen is displayed
    viewModel.fetchCharacterById(characterId)

    // Display character details
    character.value?.let { char ->
        Text(text = char.name)
        // Add more fields as needed...
    }
}
