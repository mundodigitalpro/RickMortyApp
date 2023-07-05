package com.josejordan.rickmortyapp.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.josejordan.rickmortyapp.data.Character

@Composable
fun CharacterListItem(character: Character, onClick: (Character) -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        //elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(character) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberCoilPainter(request = character.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = character.name)
        }
    }
}


/*
@Composable
fun CharacterListItem(character: Character, onClick: (Character) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(character) }
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            //elevation = 10.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberCoilPainter(request = character.image),
                contentDescription = null,
                //modifier = Modifier.fillMaxWidth(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp), // Set the height here
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = character.name)
    }
}

*/

/*
@Composable
fun CharacterListItem(character: Character, onClick: (Character) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(character) }
    ) {
        Image(
            painter = rememberCoilPainter(request = character.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(text = character.name)
    }
}
*/
