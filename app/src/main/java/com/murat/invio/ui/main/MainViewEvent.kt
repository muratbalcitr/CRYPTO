package com.murat.invio.ui.main

import com.murat.invio.network.responses.CoinsResponse

sealed class MainViewEvent {
    data class NavigateToDetail(val item: CoinsResponse.Data.Coins) : MainViewEvent() {

    }
}