package com.gh.hw_8.domain.usecase

import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.models.MovieDetails
import com.gh.hw_8.domain.repository.FavoriteMovieRepository

class FavoriteMoviesUseCase(private val favoriteMovieRepository: FavoriteMovieRepository){
    //add film in fav
    suspend fun addMovieInDataBase(favoriteMovie: FavoriteMovie){
        favoriteMovieRepository.addMovieInDataBase(favoriteMovie)
    }
    //delete film with fav
    suspend fun removeMovieFromDataBase(favoriteMovieId: Int){
        favoriteMovieRepository.removeMovieFromDataBase(favoriteMovieId)
    }
    //load list film
    fun fetchFavoriteMovies() = favoriteMovieRepository.fetchFavoriteMovies()
}