package com.murat.invio.network.responses

import android.graphics.Color
import com.google.gson.annotations.SerializedName
import java.util.regex.Pattern

data class CoinsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("data")
    val data: Data
) {
    data class Data(
        @SerializedName("stats")
        val stats: Stats?,
        @SerializedName("coins")
        val coins: ArrayList<Coins?>?
    ) {

        data class Stats(
            @SerializedName("total")
            val total: Int?,
            @SerializedName("totalMarkets")
            val totalMarkets: Int?,
            @SerializedName("totalExchanges")
            val totalExchanges: Int?,
            @SerializedName("totalMarketCap")
            val totalMarketCap: String?,
            @SerializedName("total24hVolume")
            val total24hVolume: String?
        )

        data class Coins(
            @SerializedName("uuid")
            val uuid: String?,
            @SerializedName("symbol")
            val symbol: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("color")
            val color: String?,
            @SerializedName("iconUrl")
            val iconUrl: String?,
            @SerializedName("marketCap")
            val marketCap: String?,
            @SerializedName("price")
            val price: String?,
            @SerializedName("listedAt")
            val listedAt: Int?,
            @SerializedName("tier")
            val tier: Int?,
            @SerializedName("change")
            val change: String?,
            @SerializedName("rank")
            val rank: Int?,
            @SerializedName("sparkline")
            val spirkline: ArrayList<String>?,
            @SerializedName("coinrankingUrl")
            val coinrankingUrl: String?,
            @SerializedName("24hVolume")
            val dayVolumeval: String?,
            @SerializedName("btcPrice")
            val btcPrice: String?
        ) {
            var priceFormatted: String? = null
                get() {
                    val split = price?.replace(".",",")?.split(Pattern.compile(",") , 2)
                    return (split?.get(0)) +"."+ (split?.get(1)?.substring(0, 2))
                }

            val colors: Int
                get() = try {
                    Color.parseColor(color ?: "#000000")
                } catch (e: IllegalArgumentException) {
                    Color.parseColor("#000000")
                }

        }

    }
}