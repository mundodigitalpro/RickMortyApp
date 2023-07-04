package com.josejordan.rickmortyapp.api

import com.josejordan.rickmortyapp.data.Character
import com.josejordan.rickmortyapp.data.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(): Response<CharactersResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int): Response<Character>
}
