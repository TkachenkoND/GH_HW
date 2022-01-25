package com.gh.hw_8.domain.repository

import com.gh.hw_8.domain.models.ActorDetailsList

interface ListActorRepository {

    suspend fun getListActorsDyMovieId(movieId: Int): ActorDetailsList
}