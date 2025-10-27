package com.lucas.coreui.manager

import com.lucas.coreui.base.viewModel.ViewModelState


interface ApiErrorHandler {
    fun handleError(throwable: Throwable): ViewModelState.Error

    companion object {
        const val ERROR_CODE_OFFLINE = "offline"
        const val ERROR_CODE_TIMEOUT = "timeout"
    }
}