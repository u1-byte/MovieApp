package com.u1.movieapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.u1.movieapp.R
import com.u1.movieapp.utils.ConstantVal
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    private val delayTime = ConstantVal.SPLASH_DELAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer("Splash Screen").schedule(delayTime){
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}