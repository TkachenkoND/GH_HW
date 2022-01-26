package com.gh.hw_8.di

import com.gh.hw_8.domain.usecase.FavoriteMoviesUseCase
import com.gh.hw_8.domain.usecase.LoadListActorUseCase
import com.gh.hw_8.domain.usecase.LoadMovieDetailsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { FavoriteMoviesUseCase(get()) }
    factory { LoadListActorUseCase(get()) }
    factory { LoadMovieDetailsUseCase(get()) }

}