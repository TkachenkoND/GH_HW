package com.gh.hw_8.di

import com.gh.hw_8.presentation.viewModel.FavoriteMovieActivityViewModel
import com.gh.hw_8.presentation.viewModel.MovieDetailsActivityViewModel
import com.gh.hw_8.presentation.viewModel.MovieListActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MovieListActivityViewModel(get()) }
    viewModel { MovieDetailsActivityViewModel(get(), get()) }
    viewModel { FavoriteMovieActivityViewModel(get()) }
}