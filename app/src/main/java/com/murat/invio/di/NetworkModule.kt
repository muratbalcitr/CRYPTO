package com.murat.invio.di

import com.murat.invio.network.utils.NetworkClient
import com.murat.invio.utils.PreferenceManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkClient.provideApiService(get()) }
    single { NetworkClient.provideClient(get<PreferenceManager>()) }
}
