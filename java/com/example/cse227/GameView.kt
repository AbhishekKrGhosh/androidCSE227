package com.example.cse227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val obj=GameViewDemo(this)
        setContentView(obj)
    }
}