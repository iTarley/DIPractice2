package com.example.dipractice2.domain.usecase

import com.example.dipractice2.data.models.HeroModel
import com.example.dipractice2.domain.repository.HeroRepository
import com.example.dipractice2.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(
    private val repository: HeroRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<HeroModel.Heroes>>>{
        return repository.getHeroes()
    }
}