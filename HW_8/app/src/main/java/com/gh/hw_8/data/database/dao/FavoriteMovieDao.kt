package com.gh.hw_8.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gh.hw_8.data.database.entity.FavoriteMovie

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovieInDataBase(favoriteMovie: FavoriteMovie)

    @Query("SELECT * from favorite_movies")
    fun getAllFavoriteMovieFromDataBase(): LiveData<List<FavoriteMovie>>

    @Query("DELETE FROM favorite_movies WHERE favorite_movie_id = :favoriteMovieId")
    suspend fun removeFavoriteMovieFromDataBas(favoriteMovieId: Int)
}