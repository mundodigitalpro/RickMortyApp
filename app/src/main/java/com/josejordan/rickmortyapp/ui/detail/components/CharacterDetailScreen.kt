package com.josejordan.rickmortyapp.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.coil.rememberCoilPainter
import com.josejordan.rickmortyapp.viewmodel.CharacterDetailViewModel

/*@Composable
fun CharacterDetailScreen(characterId: Int) {
    val viewModel: CharacterDetailViewModel = hiltViewModel()

    LaunchedEffect(characterId) {
        viewModel.fetchCharacterDetail(characterId)
    }

    val character = viewModel.character.observeAsState(initial = null).value

    // Check if the character data is loaded
    if (character != null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = character.name)
            Text(text = character.species)
            // Add more fields as needed
        }
    } else {
        Text(text = "Loading...")
    }
}*/

@Composable
fun CharacterDetailScreen(characterId: Int) {
    val viewModel: CharacterDetailViewModel = hiltViewModel()

    LaunchedEffect(characterId) {
        viewModel.fetchCharacterDetail(characterId)
    }

    val character = viewModel.character.observeAsState(initial = null).value

    // Check if the character data is loaded
    if (character != null) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Show character image
            Image(
                painter = rememberCoilPainter(request = character.image, fadeIn = true),
                contentDescription = "Character Image",
                modifier = Modifier.size(200.dp)
            )
            Text(text = character.name)
            Text(text = character.species)
            // Add more fields as needed
        }
    } else {
        Text(text = "Loading...")
    }
}

