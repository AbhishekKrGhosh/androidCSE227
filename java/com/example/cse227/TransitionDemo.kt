package com.example.cse227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TransitionDemo : AppCompatActivity() {
    lateinit var btn: Button
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_demo)
     btn = findViewById(R.id.button)
        btn.setOnClickListener {
            startActivity(Intent(this, GameView::class.java))
            overridePendingTransition(R.anim.sequential, R.anim.zoom_out)

        }

    }


}