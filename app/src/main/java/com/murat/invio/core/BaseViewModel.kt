package com.murat.invio.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonSyntaxException
import com.murat.invio.data.Event
import retrofit2.HttpException
import java.net.UnknownHostException


abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    private val _baseEvent = MutableLiveData<Event<BaseViewEvent>>()
    val baseEvent: LiveData<Event<BaseViewEvent>> = _baseEvent

    fun setLoading(loading: Boolean) = _loading.postValue(loading)

    private fun showCommonNetworkError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCommonNetworkError))

    private fun showConnectivityError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowConnectivityError))

    private fun showCustomError(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomError(message)))

    open fun handleException(e: Exception) {
        when (e) {
            is HttpException -> {
                when (e.code()) {
                    403 -> _baseEvent.postValue(Event(BaseViewEvent.ShowUserNotFoundError))

                    else -> {
                        if (e.code() in 499..599) {
                            _baseEvent.postValue(Event(BaseViewEvent.ShowInternalServerError))
                        } else {
                            if (e.code() in 499..599) {
                                _baseEvent.postValue(Event(BaseViewEvent.ShowInternalServerError))
                            } else {
                                try {
                                   /* showCustomError(
                                        Gson().fromJson(
                                            e.response()?.errorBody()?.string(),
                                            ApiError::class.java
                                        ).detail!!
                                    )*/
                                } catch (exception: Exception) {
                                    showCommonNetworkError()
                                }
                            }
                        }
                    }
                }
            }

            is JsonSyntaxException -> showCommonNetworkError()

            is UnknownHostException -> showConnectivityError()
        }
    }


}
