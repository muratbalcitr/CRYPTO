package com.murat.invio.ui.prelogin.splash


sealed class SplashViewEvent {

    object Start : SplashViewEvent()

    object NavigateToWelcome : SplashViewEvent()

    object NavigateToMain : SplashViewEvent()

    object NetworkError : SplashViewEvent()
}