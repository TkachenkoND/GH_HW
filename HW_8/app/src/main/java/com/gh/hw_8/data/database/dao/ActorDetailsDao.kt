package com.gh.hw_8.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gh.hw_8.domain.models.ActorDetails

@Dao
interface ActorDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActorInDataBase(actor: ActorDetails)

    @Query("SELECT * from actor_details")
    fun getAllActorListFromDataBase(): LiveData<List<ActorDetails>>

}