package com.gh.hw_8.domain.usecase

import com.gh.hw_8.domain.repository.ListActorRepository

class LoadListActorUseCase(private val listActorRepository: ListActorRepository) {

    suspend fun execute(movieId: Int) =listActorRepository.getListActorsDyMovieId(movieId)
}