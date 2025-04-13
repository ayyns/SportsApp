package com.dicoding.sports.di

import com.dicoding.core.domain.usecase.SportsInteractor
import com.dicoding.core.domain.usecase.SportsUseCase
import com.dicoding.sports.detail.DetailTourismViewModel
import com.dicoding.sports.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportsUseCase> { SportsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}