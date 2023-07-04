package com.josejordan.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josejordan.rickmortyapp.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val character = MutableLiveData<com.josejordan.rickmortyapp.data.Character>()
    val error = MutableLiveData<String>()

    fun fetchCharacterById(characterId: Int) {
        viewModelScope.launch {
            try {
                val response = characterRepository.getCharacter(characterId)
                if (response.isSuccessful) {
                    response.body()?.let { character.postValue(it) }
                } else {
                    error.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}
