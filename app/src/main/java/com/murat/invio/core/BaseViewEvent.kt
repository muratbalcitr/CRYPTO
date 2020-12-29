package com.murat.invio.core


sealed class BaseViewEvent {
    object ForceLogout : BaseViewEvent()

    object ShowCommonNetworkError : BaseViewEvent()

    object ShowConnectivityError : BaseViewEvent()

    object ShowInternalServerError : BaseViewEvent()

    object ShowUserNotFoundError : BaseViewEvent()

    data class ShowCustomError(val message: String) : BaseViewEvent()
}
