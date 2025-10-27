package com.lucas.p2p.streaming.client.di

import com.lucas.coreui.base.navigation.AppNavigator
import com.lucas.p2p.streaming.client.navigation.StubAppNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    @ActivityScoped
    abstract fun provideAppNavigator(impl: StubAppNavigator): AppNavigator
}