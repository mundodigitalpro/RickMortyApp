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
class CharacterListViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val error = MutableLiveData<String>()

    init {
        fetchAllCharacters()
    }

/*    private fun fetchAllCharacters() {
        viewModelScope.launch {
            try {
                val response = characterRepository.getAllCharacters()
                if (response.isSuccessful) {
                    response.body()?.let { characters.postValue(it.results) }
                } else {
                    error.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }*/
fun fetchAllCharacters() {
    viewModelScope.launch {
        try {
            val response = characterRepository.getAllCharacters()
            if (response.isSuccessful) {
                response.body()?.results?.let { characters.postValue(it) }
                Log.d("CharacterListViewModel", "Characters fetched successfully.")
            } else {
                error.postValue("Error: ${response.code()}")
                Log.e("CharacterListViewModel", "Error fetching characters: ${response.code()}")
            }
        } catch (e: Exception) {
            error.postValue(e.message)
            Log.e("CharacterListViewModel", "Exception fetching characters: ${e.message}")
        }
    }
}

}
