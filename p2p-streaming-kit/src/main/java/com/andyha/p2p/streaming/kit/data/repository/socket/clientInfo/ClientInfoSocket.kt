package com.lucas.p2p.streaming.kit.data.repository.socket.clientInfo

import kotlinx.coroutines.flow.Flow


interface ClientInfoSocket {
    fun sendSelfIpAddress(serverIpAdress: String)
    suspend fun receiveSubscribers(localServerAddress: String): Flow<String>
}