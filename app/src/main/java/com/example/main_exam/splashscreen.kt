package com.example.main_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.annotation.SuppressLint

import android.content.Intent
import android.os.Handler
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {
    private lateinit var appname: TextView
    private lateinit var lottie: LottieAnimationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        appname = findViewById(R.id.credit)
        lottie = findViewById(R.id.lottie)

        appname.animate()
            .translationY(-1400f)
            .setDuration(2700)
            .setStartDelay(0)

        lottie.animate()
            .translationX(2000f)
            .setDuration(2000)
            .setStartDelay(2900)

        Handler().postDelayed({
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)
    }
}
