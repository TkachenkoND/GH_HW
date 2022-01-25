package com.gh.hw_8.domain.repository

import androidx.lifecycle.LiveData
import com.gh.hw_8.domain.models.ActorDetails

interface ListActorRepository {

    suspend fun getListActorsByMovieId(movieId: Int): LiveData<List<ActorDetails>>
}