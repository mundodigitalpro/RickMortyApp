package com.josejordan.rickmortyapp.di

import com.josejordan.rickmortyapp.api.RickAndMortyApi
import com.josejordan.rickmortyapp.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(api: RickAndMortyApi): CharacterRepository {
        return CharacterRepository(api)
    }
}
