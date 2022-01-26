package com.gh.hw_8.data.services

import com.gh.hw_8.domain.models.ActorDetailsList
import retrofit2.http.GET
import retrofit2.http.Path

interface ActorDetailsListServices {
    @GET("/3/movie/{movie_id}/credits?api_key=f5cf8d703a88ed012d1f7e45101e828e&language=en-US")
    suspend fun getActorListFromServices(@Path("movie_id") movieId: Int): ActorDetailsList
}