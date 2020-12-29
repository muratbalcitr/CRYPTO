package com.murat.invio.network.repositories

import androidx.annotation.VisibleForTesting
import com.murat.invio.network.services.ApiServices
import com.murat.invio.utils.PreferenceManager

interface ApiRepository {

 }

class DefaultApiRepository(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val service: ApiServices,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val preferenceManager: PreferenceManager
) : ApiRepository {

}
