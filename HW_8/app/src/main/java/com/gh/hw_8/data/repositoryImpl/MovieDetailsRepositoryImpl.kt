package com.gh.hw_8.data.repositoryImpl

import androidx.lifecycle.LiveData
import com.gh.hw_8.data.database.dao.MovieDetailsDao
import com.gh.hw_8.data.services.MovieDetailsListServices
import com.gh.hw_8.domain.models.MovieDetails
import com.gh.hw_8.domain.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl(
    private val movieDetailsDao: MovieDetailsDao,
    private val movieDetailsListServices: MovieDetailsListServices,
) : MovieDetailsRepository {

    override suspend fun getMovieList(): LiveData<List<MovieDetails>> {
        for (movie in movieDetailsListServices.getMovieListFromServices().movieDetailsList)
            movieDetailsDao.insertMovieInDataBase(movie)

        return movieDetailsDao.getMovieListFromDataBase()
    }
}