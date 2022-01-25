package com.gh.hw_8.domain.repository

import androidx.lifecycle.LiveData
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.models.MovieDetails

interface FavoriteMovieRepository {

    suspend fun addMovieInDataBase(movie: MovieDetails)

    suspend fun removeMovieFromDataBase(movie: MovieDetails)

    fun fetchFavoriteMovies(): LiveData<List<FavoriteMovie>>

}