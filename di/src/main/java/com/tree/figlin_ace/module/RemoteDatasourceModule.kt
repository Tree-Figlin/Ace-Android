package com.tree.figlin_ace.module

import com.tree.data.remote.datasource.news.NewsDataSource
import com.tree.data.remote.datasource.news.NewsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDatasourceModule {
    @Binds
    abstract fun provideNewsDataSource(
        newsDataSourceImpl: NewsDataSourceImpl
    ): NewsDataSource
}