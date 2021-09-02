package com.example.bottomnavtienda.di

import com.example.bottomnavtienda.ui.viewmodels.CommentViewModel
import com.example.bottomnavtienda.ui.viewmodels.HomeViewModel
import com.example.bottomnavtienda.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { CommentViewModel(get()) }
     viewModel { ProductViewModel(get()) }
    /*viewModel { SplashViewModel(get(),get(),get(), get()) }
    viewModel { LoginViewModel(get()) }*/
}