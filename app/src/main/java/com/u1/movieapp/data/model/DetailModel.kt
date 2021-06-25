package com.u1.movieapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.u1.movieapp.data.remote.response.GenreResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val year: String?,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val poster: String?
) : Parcelable
