package com.example.cse227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CustomView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val d = CustomViewSmiley(this)
        super.onCreate(savedInstanceState)
        setContentView(d)
    }
}