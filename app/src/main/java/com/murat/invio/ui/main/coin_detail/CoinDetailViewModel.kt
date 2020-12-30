package com.murat.invio.ui.main.coin_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.murat.invio.core.BaseViewModel
import com.murat.invio.data.Event
import com.murat.invio.network.repositories.ApiRepository
import com.murat.invio.network.responses.CoinsDetailResponse
import com.murat.invio.network.utils.Result
import kotlinx.coroutines.launch

class CoinDetailViewModel(private val apiRepository: ApiRepository) : BaseViewModel() {

    private val _event = MutableLiveData<Event<CoinDetailViewEvent>>()
    val event: LiveData<Event<CoinDetailViewEvent>>
        get() = _event

    val coinDetail = MutableLiveData<CoinsDetailResponse>()

    fun getDetailsCoins(uuid: String) = viewModelScope.launch {
        setLoading(true)
        val response = apiRepository.getCoinsDetail(uuid)
        when (response) {
            is Result.Success -> {
                setLoading(false)
                coinDetail.postValue(response.data)
            }
            is Result.Error -> {
                setLoading(false)
                handleException(response.exception)
            }
        }
    }
}