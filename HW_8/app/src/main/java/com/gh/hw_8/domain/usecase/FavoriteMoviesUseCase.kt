package com.gh.hw_8.domain.usecase

import com.gh.hw_8.domain.models.MovieDetails
import com.gh.hw_8.domain.repository.FavoriteMovieRepository

class FavoriteMoviesUseCase(private val favoriteMovieRepository: FavoriteMovieRepository){
    //add film in fav
    suspend fun addMovieInDataBase(movie: MovieDetails){
        favoriteMovieRepository.addMovieInDataBase(movie)
    }
    //delete film with fav
    suspend fun removeMovieFromDataBase(movie: MovieDetails){
        favoriteMovieRepository.removeMovieFromDataBase(movie)
    }
    //load list film
    fun fetchFavoriteMovies() = favoriteMovieRepository.fetchFavoriteMovies()
}