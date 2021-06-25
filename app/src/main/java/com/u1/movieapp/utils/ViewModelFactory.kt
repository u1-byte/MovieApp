package com.u1.movieapp.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.remote.utils.di.AppInjection
import com.u1.movieapp.ui.detail.DetailViewModel
import com.u1.movieapp.ui.home.content.movies.MoviesViewModel
import com.u1.movieapp.ui.home.content.series.SeriesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repo: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(AppInjection.injectRepository())
        }
    }

    override fun <T : ViewModel> create(classModel: Class<T>): T {
        return when {

            classModel.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(repo) as T
            }

            classModel.isAssignableFrom(SeriesViewModel::class.java) -> {
                SeriesViewModel(repo) as T
            }

            classModel.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(repo) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + classModel.name)

        }
    }

}