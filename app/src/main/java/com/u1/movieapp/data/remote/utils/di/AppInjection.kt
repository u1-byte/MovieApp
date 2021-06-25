package com.u1.movieapp.data.remote.utils.di

import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.remote.utils.DataSources

object AppInjection {

    fun injectRepository() : DataRepository {
        return DataRepository.getInstance(DataSources.getInstance())
    }

}