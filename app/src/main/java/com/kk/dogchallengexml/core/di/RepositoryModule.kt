package com.kk.dogchallengexml.core.di

import com.kk.dogchallengexml.data.repository.RepositoryImp
import com.kk.dogchallengexml.domain.repository.IRepository
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
    abstract fun provideRepository(repositoryImp: RepositoryImp): IRepository
}