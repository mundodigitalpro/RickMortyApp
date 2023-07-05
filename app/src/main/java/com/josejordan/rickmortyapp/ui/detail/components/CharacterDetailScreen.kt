package com.josejordan.rickmortyapp.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.coil.rememberCoilPainter
import com.josejordan.rickmortyapp.viewmodel.CharacterDetailViewModel

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Show character image
            Image(
                painter = rememberCoilPainter(request = character.image, fadeIn = true),
                contentDescription = "Character Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(15.dp)) // This will make the image corners rounded
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                //elevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Name: ${character.name}")
                    Text(text = "Species: ${character.species}")
                    Text(text = "Gender: ${character.gender}")
                    Text(text = "Location: ${character.location.name}")
                    // Add more fields as needed
                }
            }
        }

    } else {
        Text(text = "Loading...")
    }
}


