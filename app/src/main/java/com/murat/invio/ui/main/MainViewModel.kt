package com.murat.invio.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.murat.invio.core.BaseViewModel

class MainViewModel: BaseViewModel() {

    private val _selectedBottomMenuState = MutableLiveData<BottomMenuState>()
    val selectedBottomMenuState: LiveData<BottomMenuState> = _selectedBottomMenuState

    fun setBottomMenuState(selectedBottomMenuState: BottomMenuState) =
        _selectedBottomMenuState.postValue(selectedBottomMenuState)

}