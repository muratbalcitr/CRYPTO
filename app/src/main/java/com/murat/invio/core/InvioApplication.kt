package com.murat.invio.core

import android.app.Application
import com.murat.invio.BuildConfig
import com.murat.invio.di.networkModule
import com.murat.invio.di.repositoryModule
import com.murat.invio.di.utilsModule
import com.murat.invio.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class InvioApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()

    }

    private fun initKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.INFO)
            androidContext(this@InvioApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    utilsModule,
                    repositoryModule
                )
            )
        }
    }
}
