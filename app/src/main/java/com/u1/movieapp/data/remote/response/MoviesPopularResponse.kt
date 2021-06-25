package com.u1.movieapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesPopularResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("release_date")
    val year: String
)