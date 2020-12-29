package com.murat.invio.di

import com.murat.invio.utils.PreferenceManager
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val utilsModule: Module = module {
    single { PreferenceManager(androidApplication()) }
}