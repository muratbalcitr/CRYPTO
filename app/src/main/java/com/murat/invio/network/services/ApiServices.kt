package com.murat.invio.network.services

import com.murat.invio.network.responses.CoinsDetailResponse
import com.murat.invio.network.responses.CoinsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("coins")
    suspend fun getCoins(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): CoinsResponse
  @GET("coin/{uuid}/")
    suspend fun getCoinsDetail(
        @Path("uuid") uuid: String
     ): CoinsDetailResponse

}