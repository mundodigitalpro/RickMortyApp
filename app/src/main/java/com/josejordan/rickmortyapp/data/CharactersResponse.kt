package com.josejordan.rickmortyapp.data

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<Character>
)

data class Info(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)

data class Character(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("location") val location: Location,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)

data class Origin(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
