package com.gh.hw_8.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movies")
data class FavoriteMovie(
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    val movieId: String,

    @ColumnInfo(name = "poster_path")
    val movieImage: String?,

    @ColumnInfo(name = "original_title")
    val movieName: String,
)
