package com.murat.invio.di

import com.murat.invio.network.repositories.ApiRepository
import com.murat.invio.network.repositories.DefaultApiRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<ApiRepository> { DefaultApiRepository(get(), get()) }
}
