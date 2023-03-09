package com.kk.dogchallengexml.data.service

import com.kk.dogchallengexml.core.utils.ResponseHandler
import com.kk.dogchallengexml.data.model.DogDTO
import com.kk.dogchallengexml.domain.model.Dog
import retrofit2.http.GET

interface IService {

    @GET("random")
    suspend fun getDog(): DogDTO
}