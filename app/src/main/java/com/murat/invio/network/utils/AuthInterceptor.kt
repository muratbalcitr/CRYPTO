package com.murat.invio.network.utils

import com.murat.invio.utils.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor(
    private val preferenceManager: PreferenceManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("accept", "application/json")
        builder.addHeader("packageName", "com.murat.invio")
        builder.addHeader(
            "x-access-token",
            "coinranking9adfcf718fa0ce1f8c4907b1a640c28632a976cb24519a64"
        )
        return chain.proceed(builder.build())
    }
}
