package com.u1.movieapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.u1.movieapp.R
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer("Splash Screen").schedule(2500){
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}