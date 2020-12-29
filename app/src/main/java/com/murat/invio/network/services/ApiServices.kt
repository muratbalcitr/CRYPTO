package com.murat.invio.network.services

import com.murat.invio.network.responses.CoinsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("coins")
    suspend fun getCoins(
        @Query("query") limit: Int,
        @Query("offset") offset: Int
    ): CoinsResponse

}