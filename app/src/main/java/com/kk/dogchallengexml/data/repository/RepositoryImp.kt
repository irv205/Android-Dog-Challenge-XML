package com.kk.dogchallengexml.data.repository

import com.kk.dogchallengexml.core.utils.ResponseHandler
import com.kk.dogchallengexml.data.mapper.toDomainModel
import com.kk.dogchallengexml.data.service.IService
import com.kk.dogchallengexml.domain.model.Dog
import com.kk.dogchallengexml.domain.repository.IRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: IService): IRepository {

    override suspend fun getDog(): ResponseHandler<Dog> {
        return try {
            ResponseHandler.Success(service.getDog().toDomainModel())
        } catch (e: Exception){
            ResponseHandler.Error(e.message.toString())
        }
    }
}