package com.bangkit.skutapp.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bangkit.skutapp.R

class SplashScreenActivity : AppCompatActivity() {
    private val duration : Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            val splashScreenIntent = Intent(this, MainActivity::class.java)
            startActivity(splashScreenIntent)
            finish()
        }, duration)
    }
}