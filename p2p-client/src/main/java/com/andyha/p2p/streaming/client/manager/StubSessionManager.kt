package com.lucas.p2p.streaming.client.manager

import com.lucas.coredata.manager.SessionManager
import com.lucas.coredata.manager.SessionState
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject


class StubSessionManager @Inject constructor(
) : SessionManager {
    override val sessionState = MutableSharedFlow<SessionState>(replay = 1)

    override fun onTokenChanged(accessToken: String?, refreshToken: String?, idToken: String?) {

    }

    override fun signOut() {

    }

    override fun isLoggedIn(): Boolean = false
}