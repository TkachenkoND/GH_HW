package com.gh.hw_8.data.repositoryImpl

import com.gh.hw_8.data.database.dao.FavoriteMovieDao
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.repository.FavoriteMovieRepository

class FavoriteMovieRepositoryImpl(private val favoriteMovieDao: FavoriteMovieDao) :
    FavoriteMovieRepository {
    override suspend fun addMovieInDataBase(favoriteMovie: FavoriteMovie) {
        favoriteMovieDao.insertFavoriteMovieInDataBase(favoriteMovie)
    }

    override suspend fun removeMovieFromDataBase(favoriteMovieId: Int) {
        favoriteMovieDao.removeFavoriteMovieFromDataBas(favoriteMovieId)
    }

    override fun fetchFavoriteMovies() = favoriteMovieDao.getAllFavoriteMovieFromDataBase()

}