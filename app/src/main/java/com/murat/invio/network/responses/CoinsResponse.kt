package com.murat.invio.network.responses

import com.google.gson.annotations.SerializedName

data class CoinsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: Data
) {
    data class Data(
        @SerializedName("stats")
        val stats: Stats,
        @SerializedName("coins")
        val coins: ArrayList<Coins?>?
    ) {

        data class Stats(
            @SerializedName("total")
            val total: Int,
            @SerializedName("totalMarkets")
            val totalMarkets: Int,
            @SerializedName("totalExchanges")
            val totalExchanges: Int,
            @SerializedName("totalMarketCap")
            val totalMarketCap: String,
            @SerializedName("total24hVolume")
            val total24hVolume: String
        )

        data class Coins(
            @SerializedName("uuid")
            val uuid: String,
            @SerializedName("symbol")
            val symbol: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("color")
            val color: String,
            @SerializedName("iconUrl")
            val iconUrl: String,
            @SerializedName("marketCap")
            val marketCap: String,
            @SerializedName("price")
            val price: String,
            @SerializedName("listedAt")
            val listedAt: Int,
            @SerializedName("tier")
            val tier: Int,
            @SerializedName("change")
            val change: String,
            @SerializedName("rank")
            val rank: Int,
            @SerializedName("sparkline")
            val spirkline: ArrayList<String>,
            @SerializedName("coinrankingUrl")
            val coinrankingUrl: String,
            @SerializedName("24hVolume")
            val dayVolumeval: String,
            @SerializedName("btcPrice")
            val btcPrice: String
        ) {
            val priceFormatted: String
                get() = price.substring(0,5)

        }

    }
}