package com.gh.hw_8.data.repositoryImpl

import androidx.lifecycle.LiveData
import com.gh.hw_8.data.database.dao.ActorDetailsDao
import com.gh.hw_8.data.services.ActorDetailsListServices
import com.gh.hw_8.domain.models.ActorDetails
import com.gh.hw_8.domain.repository.ListActorRepository

class ListActorRepositoryImpl(
    private val actorDetailsListServices: ActorDetailsListServices,
    private val actorDetailsDao: ActorDetailsDao,
) :
    ListActorRepository {

    override suspend fun getListActorsByMovieId(movieId: Int): LiveData<List<ActorDetails>> {
        for (movie in actorDetailsListServices.getActorListFromServices(movieId).cast)
            actorDetailsDao.insertActorInDataBase(movie)

        return actorDetailsDao.getAllActorListFromDataBase()
    }

}