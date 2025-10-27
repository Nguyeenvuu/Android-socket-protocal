package com.lucas.coreui.di

import android.content.Context
import com.lucas.coreutils.permission.RxPermission
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideRxPermission(@ApplicationContext context: Context): RxPermission {
        return RxPermission.getInstance(context)
    }
}