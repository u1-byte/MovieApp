package com.u1.movieapp.data.remote.api

import com.u1.movieapp.data.remote.response.ListMoviesResponse
import com.u1.movieapp.data.remote.response.ListSeriesResponse
import com.u1.movieapp.data.remote.response.MoviesDetailResponse
import com.u1.movieapp.data.remote.response.SeriesDetailResponse
import com.u1.movieapp.utils.ConstantVal.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    fun getMoviesPopular(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<ListMoviesResponse>

    @GET("tv/popular")
    fun getSeriesPopular(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<ListSeriesResponse>

    @GET("movie/{movie_id}")
    fun getMoviesDetail(
        @Path("movie_id") movId: String,
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<MoviesDetailResponse>

    @GET("tv/{tv_id}")
    fun getSeriesDetail(
        @Path("tv_id") tvId: String,
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<SeriesDetailResponse>

}