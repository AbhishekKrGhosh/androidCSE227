package com.example.cse227

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class SomethingInteresting : AppCompatActivity() {
    lateinit var animation: Button
    lateinit var iv: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_something_interesting)
        animation = findViewById(R.id.buttonAnimate)
        iv = findViewById(R.id.imageViewAnim)
        animation.setOnClickListener {
            val a= AnimationUtils.loadAnimation(applicationContext, R.anim.interestinganimation)
            iv.startAnimation(a)
        }
    }
}