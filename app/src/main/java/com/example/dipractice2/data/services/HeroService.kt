package com.example.dipractice2.data.services

import com.example.dipractice2.data.models.HeroModel
import retrofit2.Response
import retrofit2.http.GET

interface HeroService {
    @GET("c0bedb46-f50e-4cec-9cf5-e6d1d6f27241")
    suspend fun getResponse(): Response<HeroModel>
}