package com.murat.invio.network.repositories

import androidx.annotation.VisibleForTesting
import com.murat.invio.network.responses.CoinsResponse
import com.murat.invio.network.services.ApiServices
import com.murat.invio.network.utils.Result
import com.murat.invio.utils.PreferenceManager

interface ApiRepository {
    suspend fun getCoins(limit: Int, offset: Int): Result<CoinsResponse>
}

class DefaultApiRepository(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val service: ApiServices,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val preferenceManager: PreferenceManager
) : ApiRepository {
    override suspend fun getCoins(limit: Int, offset: Int): Result<CoinsResponse> {
        return try {
            Result.Success(service.getCoins(limit,offset))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}
