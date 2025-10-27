package com.lucas.p2p.streaming.client.manager

import com.lucas.coreui.base.viewModel.ViewModelState
import com.lucas.coreui.manager.ApiErrorHandler
import javax.inject.Inject


class StubApiErrorHandler @Inject constructor(
) : ApiErrorHandler {

    override fun handleError(throwable: Throwable): ViewModelState.Error {
        return ViewModelState.Error(error = "stub", shouldNotify = false)
    }
}