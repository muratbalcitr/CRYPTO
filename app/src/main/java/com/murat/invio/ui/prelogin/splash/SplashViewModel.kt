package com.murat.invio.ui.prelogin.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.murat.invio.core.BaseViewModel
import com.murat.invio.data.Event
import com.murat.invio.network.repositories.ApiRepository
import com.murat.invio.utils.PreferenceManager

class SplashViewModel(
    val prefManager: PreferenceManager,
    val apiRepository: ApiRepository
) : BaseViewModel() {

    private val _event = MutableLiveData<Event<SplashViewEvent>>()
    val event: LiveData<Event<SplashViewEvent>> = _event

    fun continueProcess() {
        navigateToMain()
    }

    fun navigateToMain() =
        _event.postValue(Event(SplashViewEvent.NavigateToMain))


}
