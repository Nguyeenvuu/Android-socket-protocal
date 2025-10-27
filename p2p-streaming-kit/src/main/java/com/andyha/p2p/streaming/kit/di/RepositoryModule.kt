package com.lucas.p2p.streaming.kit.di

import com.lucas.p2p.streaming.kit.data.repository.client.ClientRepository
import com.lucas.p2p.streaming.kit.data.repository.client.ClientRepositoryImpl
import com.lucas.p2p.streaming.kit.data.repository.server.ServerRepository
import com.lucas.p2p.streaming.kit.data.repository.server.ServerRepositoryImpl
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
    abstract fun bindServerRepository(impl: ServerRepositoryImpl): ServerRepository

    @Binds
    @Singleton
    abstract fun bindClientRepository(impl: ClientRepositoryImpl): ClientRepository
}