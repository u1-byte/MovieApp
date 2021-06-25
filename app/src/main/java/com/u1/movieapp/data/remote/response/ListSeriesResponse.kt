package com.u1.movieapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListSeriesResponse (
    @SerializedName("results")
    val results: List<SeriesPopularResponse>
)