package com.dicoding.favorite.di

import com.dicoding.favorite.FavoriteViewModel
import com.dicoding.favorite.detail.FavoriteDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
    viewModel { FavoriteDetailViewModel(get()) }
}