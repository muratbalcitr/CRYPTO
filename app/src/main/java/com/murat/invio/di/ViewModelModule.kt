package com.murat.invio.di

import com.murat.invio.ui.prelogin.PreLoginViewModel
import com.murat.invio.ui.prelogin.splash.SplashViewModel
import com.murat.invio.ui.main.MainViewModel
import com.murat.invio.ui.main.coin_detail.CoinDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@ExperimentalCoroutinesApi
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { PreLoginViewModel() }
    viewModel { CoinDetailViewModel(get())}
}
