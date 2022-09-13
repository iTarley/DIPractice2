package com.example.dipractice2.di

import com.example.dipractice2.data.repository.HeroRepositoryImpl
import com.example.dipractice2.domain.repository.HeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHeroRepository(
        heroRepositoryImpl: HeroRepositoryImpl
    ): HeroRepository

}