package com.gh.hw_8.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "actor_details")
@JsonClass(generateAdapter = true)
data class ActorDetails(

    @ColumnInfo(name = "actor_image")
    @Json(name = "profile_path")
    val actorImage: String?,

    @PrimaryKey
    @ColumnInfo(name = "actor_name")
    @Json(name = "name")
    val actorName: String,
)
