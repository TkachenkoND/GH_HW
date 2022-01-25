package com.gh.hw_8.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "movie_details")
@JsonClass(generateAdapter = true)
data class MovieDetails(
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @Json(name = "id")
    val movieId: String,

    @ColumnInfo(name = "poster_path")
    @Json(name = "poster_path")
    val movieImage: String?,

    @ColumnInfo(name = "original_title")
    @Json(name = "original_title")
    val movieName: String,

    @ColumnInfo(name = "release_date")
    @Json(name = "release_date")
    val movieReleaseDate: String,

    @ColumnInfo(name = "overview")
    @Json(name = "overview")
    val overview: String,

    @ColumnInfo(name = "backdrop_path")
    @Json(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "vote_average")
    @Json(name = "vote_average")
    val rating: String,
)
