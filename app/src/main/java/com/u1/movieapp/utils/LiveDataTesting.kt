package com.u1.movieapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class LiveDataTesting {
    companion object {
        fun <T> getValue(liveData: LiveData<T>): T {
            val data = arrayOfNulls<Any>(1)
            val cdLatch = CountDownLatch(1)

            val observer = object : Observer<T> {
                override fun onChanged(o: T) {
                    data[0] = o
                    cdLatch.countDown()
                    liveData.removeObserver(this)
                }
            }

            liveData.observeForever(observer)

            try {
                cdLatch.await(2, TimeUnit.SECONDS)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            return data[0] as T
        }
    }
}