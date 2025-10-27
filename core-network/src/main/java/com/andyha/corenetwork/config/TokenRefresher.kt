package com.lucas.corenetwork.config


interface TokenRefresher {
    fun refreshToken(): String?
}