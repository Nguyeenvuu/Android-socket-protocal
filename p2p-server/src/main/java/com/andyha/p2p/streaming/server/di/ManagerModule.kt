package com.lucas.p2p.streaming.server.di

import com.lucas.coredata.manager.ConfigurationManager
import com.lucas.coredata.manager.NetworkConnectionManager
import com.lucas.coredata.manager.SessionManager
import com.lucas.coreextension.localehelper.LocaleManager
import com.lucas.coreui.manager.ApiErrorHandler
import com.lucas.p2p.streaming.server.manager.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun bindConfigurationManager(configurationManagerImpl: ConfigurationManagerImpl): ConfigurationManager

    @Binds
    @Singleton
    abstract fun bindNetworkManager(networkManagerImpl: NetworkConnectionManagerImpl): NetworkConnectionManager

    @Binds
    @Singleton
    abstract fun bindAppErrorManager(apiErrorManagerImpl: StubApiErrorHandler): ApiErrorHandler

    @Binds
    @Singleton
    abstract fun bindLocaleManager(localeManager: LocaleManagerImpl): LocaleManager

    @Binds
    @Singleton
    abstract fun bindSessionManager(sessionManager: StubSessionManager): SessionManager
}