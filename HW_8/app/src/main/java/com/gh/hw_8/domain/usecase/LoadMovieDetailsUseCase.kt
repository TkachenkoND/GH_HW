package com.gh.hw_8.domain.usecase

import com.gh.hw_8.domain.repository.MovieDetailsRepository

class LoadMovieDetailsUseCase(private val movieDetailsRepository: MovieDetailsRepository) {

    suspend fun execute() = movieDetailsRepository.getMovieList()
}