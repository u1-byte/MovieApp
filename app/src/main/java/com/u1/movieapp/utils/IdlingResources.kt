package com.u1.movieapp.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object IdlingResources {

    private const val RESOURCE = "GLOBAL"
    private val idlingRes = CountingIdlingResource(RESOURCE)

    fun getIdlingRes(): IdlingResource = idlingRes

    fun increment() = idlingRes.increment()

    fun decrement() = idlingRes.decrement()

}