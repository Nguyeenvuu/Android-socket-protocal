package com.lucas.wifidirectkit.di

import com.lucas.wifidirectkit.manager.WifiDirectManager
import com.lucas.wifidirectkit.manager.WifiDirectManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {
    @Binds
    abstract fun bindWifiDirectManager(impl: WifiDirectManagerImpl): WifiDirectManager

}