package com.gh.hw_8.domain.repository

import androidx.lifecycle.LiveData
import com.gh.hw_8.data.database.entity.FavoriteMovie

interface FavoriteMovieRepository {

    suspend fun addMovieInDataBase(favoriteMovie: FavoriteMovie)

    suspend fun removeMovieFromDataBase(favoriteMovieId: Int)

    fun fetchFavoriteMovies(): LiveData<List<FavoriteMovie>>

}