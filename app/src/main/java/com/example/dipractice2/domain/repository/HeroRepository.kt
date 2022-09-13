package com.example.dipractice2.domain.repository


import com.example.dipractice2.data.models.HeroModel
import com.example.dipractice2.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    suspend fun getHeroes(): Flow<Resource<List<HeroModel.Heroes>>>
}