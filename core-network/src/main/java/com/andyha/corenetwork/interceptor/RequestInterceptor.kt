package com.lucas.corenetwork.interceptor

import android.content.Context
import android.os.Build
import com.lucas.coredata.storage.preference.AppSharedPreference
import com.lucas.coreextension.getDeviceId
import com.lucas.coreextension.versionName
import com.lucas.corenetwork.config.NetworkConfigConstants
import com.lucas.coredata.storage.preference.deviceLocale
import com.lucas.coredata.storage.preference.imei
import com.lucas.coredata.storage.preference.token
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    private val context: Context,
    private val prefs: AppSharedPreference,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        if (chain.request().header("unAuthorized") == null){
            val accessToken = prefs.token
            if (accessToken.isNotEmpty()) {
                builder.header(NetworkConfigConstants.AUTHORIZATION, "${NetworkConfigConstants.BEARER} $accessToken")
            }
        }else{
            builder.removeHeader("unAuthorized")
        }

        builder.header("X-APP-VERSION", context.versionName())
        prefs.imei?.let { builder.header("X-IMEI", it) }
        context.getDeviceId()?.let {
            builder.header("X-Device-Identifier", it)
            builder.header("User-Agent", it)
        }
        builder.header("X-Device-Family", Build.MODEL)
        prefs.deviceLocale?.let { builder.header("X-Device-Locale", it) }
        builder.header("X-Device-Platform", "android")
        builder.header("X-Device-OS-Version", "android ${Build.VERSION.RELEASE}") //android 10
        builder.header("Content-Type", "application/json")
        return chain.proceed(builder.build())
    }
}