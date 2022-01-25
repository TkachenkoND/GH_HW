package com.gh.hw_8.domain.repository

import com.gh.hw_8.domain.models.MovieDetailsList

interface MovieDetailsRepository {

    fun getMovieList(): MovieDetailsList
}