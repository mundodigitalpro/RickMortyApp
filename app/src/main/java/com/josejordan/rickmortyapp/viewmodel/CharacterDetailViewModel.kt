package com.josejordan.rickmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josejordan.rickmortyapp.data.Character
import com.josejordan.rickmortyapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val character = MutableLiveData<Character>()
    val error = MutableLiveData<String>()

    fun fetchCharacterDetail(characterId: Int) {
        viewModelScope.launch {
            try {
                val response = characterRepository.getCharacter(characterId)
                if (response.isSuccessful) {
                    response.body()?.let { character.postValue(it) }
                    Log.d("CharacterDetailViewModel", "Character details fetched successfully.")
                } else {
                    error.postValue("Error: ${response.code()}")
                    Log.e("CharacterDetailViewModel", "Error fetching character details: ${response.code()}")
                }
            } catch (e: Exception) {
                error.postValue(e.message)
                Log.e("CharacterDetailViewModel", "Exception fetching character details: ${e.message}")
            }
        }
    }
}
