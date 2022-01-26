package com.gh.hw_8.domain.repository

import androidx.lifecycle.LiveData
import com.gh.hw_8.domain.models.MovieDetails

interface MovieDetailsRepository {

    suspend fun getMovieList(): LiveData<List<MovieDetails>>
}