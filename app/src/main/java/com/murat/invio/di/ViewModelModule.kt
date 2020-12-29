package com.murat.invio.di

import com.murat.invio.ui.prelogin.PreLoginViewModel
import com.murat.invio.ui.prelogin.splash.SplashViewModel
import com.murat.invio.ui.main.MainActivityViewModel
import com.murat.invio.ui.main.MainViewModel
import com.murat.invio.ui.main.article.ArticleViewModel
import com.murat.invio.ui.main.author.AuthorViewModel
import com.murat.invio.ui.main.detail_author_package.DetailAuthorViewModel
import com.murat.invio.ui.main.detail_newspaper_package.DetailNewspaperViewModel
import com.murat.invio.ui.main.newspaper.NewspaperViewModel
import com.murat.invio.ui.main.search_new.SearchViewModel
import com.murat.invio.ui.main.web_view.WebViewViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@ExperimentalCoroutinesApi
val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { AuthorViewModel(get(), get()) }
    viewModel { ArticleViewModel(get(), get()) }
    viewModel { MainViewModel() }
    viewModel { WebViewViewModel() }
    viewModel { DetailAuthorViewModel(get(),get()) }
    viewModel { DetailNewspaperViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { PreLoginViewModel() }
    viewModel { SearchViewModel(get(),get()) }
    viewModel { NewspaperViewModel(get()) }
}
