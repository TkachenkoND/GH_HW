package com.gh.hw_8.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gh.hw_8.domain.models.MovieDetails

@Dao
interface MovieDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieInDataBase(movie: MovieDetails)

    @Query("SELECT * from movie_details")
    fun getMovieListFromDataBase(): LiveData<List<MovieDetails>>

}