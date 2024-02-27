package com.example.cse227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val backgroundImage: ImageView = findViewById(R.id.imageViewSplash)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.sideslide)
        backgroundImage.startAnimation(slideAnimation)
        Handler().postDelayed({
            val intent = Intent(this, AnimationDemo::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}