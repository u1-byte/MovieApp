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

class FakeRepositoryTest(private val dataSources: DataSources) : DataBuilderInterface {
    override fun getMovies(): LiveData<List<MoviesModel>> {

        val moviesRes = MutableLiveData<List<MoviesModel>>()

        dataSources.getMoviesList(object : DataSources.LoadMoviesListCallback {
            override fun onMoviesLoad(data: List<MoviesPopularResponse>?) {

                val moviesList = ArrayList<MoviesModel>()

                if (data != null) {
                    for (responses in data) {
                        with(responses) {
                            val movie = MoviesModel(id, title, poster)
                            moviesList.add(movie)
                        }
                    }
                    moviesRes.postValue(moviesList)
                }
            }
        })

        return moviesRes

    }

    override fun getSeries(): LiveData<List<SeriesModel>> {
        val seriesRes = MutableLiveData<List<SeriesModel>>()

        dataSources.getSeriesList(object : DataSources.LoadSeriesListCallback {
            override fun onSeriesLoad(data: List<SeriesPopularResponse>?) {

                val seriesList = ArrayList<SeriesModel>()

                if (data != null) {
                    for (responses in data) {
                        with(responses) {
                            val series = SeriesModel(id, title, poster)
                            seriesList.add(series)
                        }
                    }
                    seriesRes.postValue(seriesList)
                }
            }
        })

        return seriesRes
    }

    override fun getMoviesDetail(id: String): LiveData<DetailModel> {

        val moviesDetail = MutableLiveData<DetailModel>()

        dataSources.getDetailMovies(object : DataSources.LoadDetailMoviesCallback {
            override fun onDetailMoviesLoad(data: MoviesDetailResponse?) {
                if (data != null) {
                    with(data) {
                        val listGenres = ArrayList<String>()
                        for (genre in genres) listGenres.add(genre.name)

                        val detailRes = DetailModel(
                                id = this.id,
                                title = title,
                                genres = listGenres,
                                poster = poster,
                                overview = overview,
                                year = year
                        )

                        moviesDetail.postValue(detailRes)
                    }
                }
            }

        }, id)

        return moviesDetail
    }

    override fun getSeriesDetail(id: String): LiveData<DetailModel> {
        val seriesDetail = MutableLiveData<DetailModel>()

        dataSources.getDetailSeries(object : DataSources.LoadDetailSeriesCallback {
            override fun onDetailSeriesLoad(data: SeriesDetailResponse?) {
                if (data != null) {
                    with(data) {
                        val listGenres = ArrayList<String>()
                        for (genre in genres) listGenres.add(genre.name)

                        val detailRes = DetailModel(
                                id = this.id,
                                title = title,
                                genres = listGenres,
                                poster = poster,
                                overview = overview,
                                year = year
                        )

                        seriesDetail.postValue(detailRes)
                    }
                }
            }

        }, id)

        return seriesDetail
    }

}