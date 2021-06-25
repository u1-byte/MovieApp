package com.u1.movieapp.data.remote.utils

import android.util.Log
import com.u1.movieapp.data.remote.api.RetrofitBuilder
import com.u1.movieapp.data.remote.response.*
import com.u1.movieapp.utils.IdlingResources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSources {

    companion object {
        @Volatile
        private var instance: DataSources? = null
        fun getInstance(): DataSources = instance ?: synchronized(this) {
            instance ?: DataSources()
        }
    }

    interface LoadMoviesListCallback {
        fun onMoviesLoad(data: List<MoviesPopularResponse>?)
    }

    interface LoadSeriesListCallback {
        fun onSeriesLoad(data: List<SeriesPopularResponse>?)
    }

    interface LoadDetailMoviesCallback {
        fun onDetailMoviesLoad(data: MoviesDetailResponse?)
    }

    interface LoadDetailSeriesCallback {
        fun onDetailSeriesLoad(data: SeriesDetailResponse?)
    }

    fun getMoviesList(callback: LoadMoviesListCallback){
        IdlingResources.increment()
        val apiInstance = RetrofitBuilder.getServices().getMoviesPopular()
        apiInstance.enqueue(object : Callback<ListMoviesResponse> {
            override fun onResponse(
                call: Call<ListMoviesResponse>,
                response: Response<ListMoviesResponse>
            ) {
                callback.onMoviesLoad(response.body()?.results)
                IdlingResources.decrement()
            }

            override fun onFailure(call: Call<ListMoviesResponse>, t: Throwable) {
                Log.e("Data Sources", "getMoviesList error : ${t.message}")
                IdlingResources.decrement()
            }
        })
    }

    fun getSeriesList(callback: LoadSeriesListCallback){
        IdlingResources.increment()
        val apiInstance = RetrofitBuilder.getServices().getSeriesPopular()
        apiInstance.enqueue(object : Callback<ListSeriesResponse> {
            override fun onResponse(
                call: Call<ListSeriesResponse>,
                response: Response<ListSeriesResponse>
            ) {
                callback.onSeriesLoad(response.body()?.results)
                IdlingResources.decrement()
            }

            override fun onFailure(call: Call<ListSeriesResponse>, t: Throwable) {
                Log.e("Data Sources", "getSeriesList error : ${t.message}")
                IdlingResources.decrement()
            }
        })
    }

    fun getDetailMovies(callback: LoadDetailMoviesCallback, id: String){
        IdlingResources.increment()
        val apiInstance = RetrofitBuilder.getServices().getMoviesDetail(id)
        apiInstance.enqueue(object : Callback<MoviesDetailResponse> {
            override fun onResponse(
                call: Call<MoviesDetailResponse>,
                response: Response<MoviesDetailResponse>
            ) {
                callback.onDetailMoviesLoad(response.body())
                IdlingResources.decrement()
            }

            override fun onFailure(call: Call<MoviesDetailResponse>, t: Throwable) {
                Log.e("Data Sources", "getDetailMovies error : ${t.message}")
                IdlingResources.decrement()
            }
        })
    }

    fun getDetailSeries(callback: LoadDetailSeriesCallback, id: String){
        IdlingResources.increment()
        val apiInstance = RetrofitBuilder.getServices().getSeriesDetail(id)
        apiInstance.enqueue(object : Callback<SeriesDetailResponse> {
            override fun onResponse(
                call: Call<SeriesDetailResponse>,
                response: Response<SeriesDetailResponse>
            ) {
                callback.onDetailSeriesLoad(response.body())
                IdlingResources.decrement()
            }

            override fun onFailure(call: Call<SeriesDetailResponse>, t: Throwable) {
                Log.e("Data Sources", "getDetailSeries error : ${t.message}")
                IdlingResources.decrement()
            }
        })
    }

}