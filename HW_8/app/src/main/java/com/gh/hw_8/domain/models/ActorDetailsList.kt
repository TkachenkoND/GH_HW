package com.gh.hw_8.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActorDetailsList(
    @Json(name = "cast")
    val cast: List<ActorDetails>,
)
