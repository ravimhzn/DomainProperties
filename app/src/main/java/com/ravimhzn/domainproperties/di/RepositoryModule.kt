package com.ravimhzn.domainproperties.di

import com.ravimhzn.domainproperties.repository.DomainPropertyDataSource
import com.ravimhzn.domainproperties.repository.DomainPropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDigitalCardDataSource(repository: DomainPropertyRepository): DomainPropertyDataSource =
        repository
}
