package com.kk.dogchallengexml.domain.repository

import com.kk.dogchallengexml.core.utils.ResponseHandler
import com.kk.dogchallengexml.domain.model.Dog

interface IRepository {
    suspend fun getDog(): ResponseHandler<Dog>
}