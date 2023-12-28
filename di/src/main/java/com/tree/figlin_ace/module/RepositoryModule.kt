package com.tree.figlin_ace.module

import com.tree.data.repository.LocationRepositoryImpl
import com.tree.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}