package com.josejordan.rickmortyapp.repository

import com.josejordan.rickmortyapp.api.RickAndMortyApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: RickAndMortyApi
) {
    suspend fun getAllCharacters() = api.getAllCharacters()

    suspend fun getCharacter(characterId: Int) = api.getCharacter(characterId)
}
