package com.josejordan.rickmortyapp.ui

sealed class Screen(val route: String) {
    object CharacterList : Screen("CharacterList")
    data class CharacterDetail(val characterId: Int) : Screen("CharacterDetail/$characterId")
}
