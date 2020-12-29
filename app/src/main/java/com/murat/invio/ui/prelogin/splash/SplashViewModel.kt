package com.murat.invio.ui.prelogin.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.murat.invio.core.BaseViewModel
import com.murat.invio.data.Event
import com.murat.invio.network.repositories.ApiRepository
import com.murat.invio.network.utils.Result
import com.murat.invio.utils.PreferenceManager
import kotlinx.coroutines.launch

class SplashViewModel(
    val prefManager: PreferenceManager,
    val apiRepository: ApiRepository
) : BaseViewModel() {

    private val _event = MutableLiveData<Event<SplashViewEvent>>()
    val event: LiveData<Event<SplashViewEvent>> = _event

    val deviceId = MutableLiveData<String>()
    var counter = 0

    fun continueProcess() {
        if (!prefManager.clientId.isNullOrEmpty()) {
            navigateToMain()
        } else {
            navigateToWelcome()
        }
    }

    fun navigateToMain() =
        _event.postValue(Event(SplashViewEvent.NavigateToMain))

    fun navigateToWelcome() =
        _event.postValue(Event(SplashViewEvent.NavigateToWelcome))

    fun addClient(clientRequest: ClientRequest) = viewModelScope.launch {
            prefManager.clientId = clientRequest.clientId
            val response = apiRepository.postClient(clientRequest)
            when (response) {
                is Result.Success -> {
                    continueProcess()
                }
                is Result.Error -> {
                    continueProcess()
                }
            }
    }
}
