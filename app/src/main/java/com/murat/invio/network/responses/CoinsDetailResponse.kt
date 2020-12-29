package com.murat.invio.network.responses

import android.graphics.Color
import com.google.gson.annotations.SerializedName
import java.util.regex.Pattern

data class CoinsDetailResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("data")
    val data: Data
) {
    data class Data(
        @SerializedName("coin")
        val coins: Coins
    ) {
        data class Coins(
            @SerializedName("uuid")
            val uuid: String?,
            @SerializedName("symbol")
            val symbol: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("color")
            val color: String?,
            @SerializedName("iconUrl")
            val iconUrl: String?,
            @SerializedName("marketCap")
            val marketCap: String?,
            @SerializedName("websiteUrl")
            val websiteUrl: String?,
            @SerializedName("links")
            val links:ArrayList<Links>?,
            @SerializedName("price")
            val price: String?,
            @SerializedName("supply")
            val supply: Supply?,
            @SerializedName("numberOfMarkets")
            val numberOfMarkets: Int?,
            @SerializedName("numberOfExchanges")
            val numberOfExchanges: Int?,
            @SerializedName("24hVolume")
            val dayVolume: String?,
            @SerializedName("change")
            val change: String?,
            @SerializedName("rank")
            val rank: Int?,
            @SerializedName("allTimeHigh")
            val allTimeHigh: AllTimeHigh?,
            @SerializedName("sparkline")
            val spirkline: ArrayList<String>?,
            @SerializedName("coinrankingUrl")
            val coinrankingUrl: String?,
            @SerializedName("btcPrice")
            val btcPrice: String?
        ) {
            data class AllTimeHigh(
                @SerializedName("price")
                val price: String,
                @SerializedName("timestamp")
                val timestamp: Long
            )

            data class Links(
                @SerializedName("name")
                val name: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("url")
                val url: String
            )

            data class Supply(
                @SerializedName("comfirmed")
                val comfirmed: String,
                @SerializedName("total")
                val total: String,
                @SerializedName("circulating")
                val circulating: String

                )

            var priceFormatted: String? = null
                get() {
                    val split = price?.replace(".", ",")?.split(Pattern.compile(","), 2)
                    return (split?.get(0)) + "." + (split?.get(1)?.substring(0, 2)+"$")
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