package com.murat.invio.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.murat.invio.core.BaseViewModel
import com.murat.invio.data.Event
import com.murat.invio.network.repositories.ApiRepository
import com.murat.invio.network.responses.CoinsResponse
import com.murat.invio.network.utils.Result
import kotlinx.coroutines.launch


class MainViewModel(
    val apiRepository: ApiRepository
) : BaseViewModel() {

    val isLoadingMore = MutableLiveData<Boolean>(false)
    private val _event = MutableLiveData<Event<MainViewEvent>>()
    val event: LiveData<Event<MainViewEvent>>
        get() = _event
    val _coins = MutableLiveData<CoinsResponse>()
    val coins: LiveData<CoinsResponse>
        get() = _coins
    val offset = MutableLiveData<Int>(0)
    val limit = MutableLiveData<Int>(10)

    fun getCoins(offset: Int) = viewModelScope.launch {
        val response = apiRepository.getCoins(limit.value!!, offset)
        when (response) {
            is Result.Success -> {
                _coins.postValue(response.data)
            }
            is Result.Error -> {
                handleException(response.exception)
            }
        }
    }
}
