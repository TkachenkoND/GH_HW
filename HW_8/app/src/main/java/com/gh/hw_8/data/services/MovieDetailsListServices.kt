package com.gh.hw_8.data.services

import com.gh.hw_8.domain.models.MovieDetailsList
import retrofit2.http.GET

interface MovieDetailsListServices {
    @GET("/3/movie/popular?api_key=f5cf8d703a88ed012d1f7e45101e828e&language=en-US&page=1")
    suspend fun getMovieListFromServices(): MovieDetailsList
}