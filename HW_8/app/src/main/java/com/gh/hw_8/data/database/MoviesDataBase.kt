package com.gh.hw_8.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gh.hw_8.data.database.dao.ActorDetailsDao
import com.gh.hw_8.data.database.dao.FavoriteMovieDao
import com.gh.hw_8.data.database.dao.MovieDetailsDao
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.models.ActorDetails
import com.gh.hw_8.domain.models.MovieDetails

@Database(entities = [ActorDetails::class, MovieDetails::class, FavoriteMovie::class], version = 1)
abstract class MoviesDataBase : RoomDatabase() {

    abstract fun getActorDetailsDao(): ActorDetailsDao
    abstract fun getFavoriteMovieDao(): FavoriteMovieDao
    abstract fun getMovieDetailsDao(): MovieDetailsDao

}