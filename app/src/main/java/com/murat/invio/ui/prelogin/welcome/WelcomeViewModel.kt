package com.murat.invio.ui.prelogin.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.murat.invio.core.BaseViewModel
import com.murat.invio.data.Event

/**
 * @user: omer.karaca
 * @date: 2020-01-19
 */

class WelcomeViewModel : BaseViewModel() {

    private val _event = MutableLiveData<Event<WelcomeViewEvent>>()
    val event: LiveData<Event<WelcomeViewEvent>> = _event

    val _loadingProgressBar = MutableLiveData<Boolean>()
    val loadingProgressBar: LiveData<Boolean> = _loadingProgressBar

    fun navigateToMain() {
        _loadingProgressBar.postValue(true)
        _event.postValue(Event(WelcomeViewEvent.NavigateToMain))
        _loadingProgressBar.postValue(false)
    }
}
