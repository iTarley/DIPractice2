package com.example.dipractice2.data.repository

import com.example.dipractice2.data.models.HeroModel
import com.example.dipractice2.data.services.HeroService
import com.example.dipractice2.domain.repository.HeroRepository
import com.example.dipractice2.utils.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(private val api:HeroService):HeroRepository {
    override suspend fun getHeroes() = flow<Resource<List<HeroModel.Heroes>>> {
        try{
            emit(Resource.Loading(isLoading = true))
            val response = api.getResponse()
            val result = response.body()?.heroes
            if(response.isSuccessful){
                emit(Resource.Success(result!!))
            }else{
                emit(Resource.Error(response.message()))
            }

        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }


    }
}