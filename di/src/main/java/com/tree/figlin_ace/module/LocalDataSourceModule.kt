package com.tree.figlin_ace.module

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.tree.data.datasource.LocationDataSource
import com.tree.data.datasource.LocationDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideLocationClient(
        @ApplicationContext context: Context
    ): LocationDataSource = LocationDataSourceImpl(
        context,
        LocationServices.getFusedLocationProviderClient(context)
    )
}