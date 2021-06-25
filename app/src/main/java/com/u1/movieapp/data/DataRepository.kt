package com.u1.movieapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.u1.movieapp.data.model.DetailModel
import com.u1.movieapp.data.model.MoviesModel
import com.u1.movieapp.data.model.SeriesModel
import com.u1.movieapp.data.remote.response.MoviesDetailResponse
import com.u1.movieapp.data.remote.response.MoviesPopularResponse
import com.u1.movieapp.data.remote.response.SeriesDetailResponse
import com.u1.movieapp.data.remote.response.SeriesPopularResponse
import com.u1.movieapp.data.remote.utils.DataBuilderInterface
import com.u1.movieapp.data.remote.utils.DataSources

class DataRepository private constructor(private val dataSources: DataSources) : DataBuilderInterface {

    companion object{
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(data: DataSources): DataRepository = instance ?: synchronized(this) {
            instance ?: DataRepository(data)
        }
    }

    override fun getMovies(): LiveData<List<MoviesModel>> {
        val moviesList = MutableLiveData<List<MoviesModel>>()

        dataSources.getMoviesList(object : DataSources.LoadMoviesListCallback {
            override fun onMoviesLoad(data: List<MoviesPopularResponse>?) {
                val moviesData = ArrayList<MoviesModel>()

                if (data != null) {
                    for (dt in data) {
                        with(dt) {
                            val res = MoviesModel(id, title, poster)
                            moviesData.add(res)
                        }
                    }
                    moviesList.postValue(moviesData)
                }
            }
        })

        return moviesList
    }

    override fun getSeries(): LiveData<List<SeriesModel>> {
        val seriesList = MutableLiveData<List<SeriesModel>>()

        dataSources.getSeriesList(object : DataSources.LoadSeriesListCallback {
            override fun onSeriesLoad(data: List<SeriesPopularResponse>?) {
                val seriesData = ArrayList<SeriesModel>()

                if (data != null) {
                    for (dt in data) {
                        with(dt) {
                            val res = SeriesModel(id, title, poster)
                            seriesData.add(res)
                        }
                    }
                    seriesList.postValue(seriesData)
                }
            }
        })

        return seriesList
    }

    override fun getMoviesDetail(movId: String): LiveData<DetailModel> {
        val moviesDetail = MutableLiveData<DetailModel>()

        dataSources.getDetailMovies(object : DataSources.LoadDetailMoviesCallback {
            override fun onDetailMoviesLoad(data: MoviesDetailResponse?) {
                if (data != null) {
                    with(data) {
                        val listGenres = ArrayList<String>()
                        for (genre in genres) listGenres.add(genre.name)
                        val detailRes = DetailModel(
                            id = id,
                            title = title,
                            year = year,
                            genres = listGenres,
                            overview = overview,
                            poster = poster
                        )
                        moviesDetail.postValue(detailRes)
                    }
                }
            }
        }, movId)

        return moviesDetail
    }

    override fun getSeriesDetail(tvId: String): LiveData<DetailModel> {
        val seriesDetail = MutableLiveData<DetailModel>()

        dataSources.getDetailSeries(object : DataSources.LoadDetailSeriesCallback {
            override fun onDetailSeriesLoad(data: SeriesDetailResponse?) {
                if (data != null) {
                    with(data) {
                        val listGenres = ArrayList<String>()
                        for (genre in genres) listGenres.add(genre.name)
                        val detailRes = DetailModel(
                            id = id,
                            title = title,
                            year = year,
                            genres = listGenres,
                            overview = overview,
                            poster = poster
                        )
                        seriesDetail.postValue(detailRes)
                    }
                }
            }
        }, tvId)

        return seriesDetail
    }
}