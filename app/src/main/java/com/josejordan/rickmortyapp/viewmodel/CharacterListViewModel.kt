package com.josejordan.rickmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MediatorLiveData
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
    val searchQuery = MutableLiveData<String>("")

    // LiveData to hold filtered characters
    val filteredCharacters = MediatorLiveData<List<Character>>()

    init {
        fetchAllCharacters()

        // Observe changes in characters and searchQuery
        filteredCharacters.addSource(characters) {
            filteredCharacters.value = filterCharacters(it, searchQuery.value ?: "")
        }
        filteredCharacters.addSource(searchQuery) {
            filteredCharacters.value = filterCharacters(characters.value ?: emptyList(), it)
        }
    }

    private fun fetchAllCharacters() {
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

    // Function to filter characters based on the search query
    private fun filterCharacters(characters: List<Character>, query: String): List<Character> {
        return if (query.isEmpty()) {
            characters
        } else {
            characters.filter { character ->
                character.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun setSearchQuery(query: String) {
        searchQuery.value = query
    }
}
