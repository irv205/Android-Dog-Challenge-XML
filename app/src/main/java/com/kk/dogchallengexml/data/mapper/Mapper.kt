package com.kk.dogchallengexml.data.mapper

import com.kk.dogchallengexml.data.model.DogDTO
import com.kk.dogchallengexml.domain.model.Dog

fun DogDTO.toDomainModel(): Dog = Dog(message)