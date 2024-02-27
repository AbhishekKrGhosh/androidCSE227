package com.example.cse227

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class AnimationDemo : AppCompatActivity() {
    lateinit var iv: ImageView
    lateinit var b: Button
    lateinit var r: Button
    lateinit var bn: Button
    lateinit var fin: Button
    lateinit var fout: Button
    lateinit var move : Button
    lateinit var flip : Button
    lateinit var zin: Button
    lateinit var zout: Button
    lateinit var zr: Button
    lateinit var seq: Button
    lateinit var sUp: Button
    lateinit var sDn: Button
    lateinit var sLeft: Button
    lateinit var sRight: Button
    lateinit var sideSlide: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo)
        iv = findViewById(R.id.iv)
        b = findViewById(R.id.button2)
        r = findViewById(R.id.buttonR)
        bn = findViewById(R.id.buttonB)
        fin = findViewById(R.id.buttonin)
        fout = findViewById(R.id.buttonout)
        move = findViewById(R.id.buttonM)
        flip = findViewById(R.id.buttonFlip)
        zin = findViewById(R.id.buttonZi)
        zout = findViewById(R.id.buttonZo)
        zr = findViewById(R.id.buttonzr)
        seq = findViewById(R.id.buttonSeq)
        sUp = findViewById(R.id.buttonSUp)
        sDn = findViewById(R.id.buttonSDn)
        sLeft = findViewById(R.id.buttonSLeft)
        sRight = findViewById(R.id.buttonSRight)
        sideSlide = findViewById(R.id.buttonSideSlide)
        //val a=AlphaAnimation(0.0f, 1.0f)
        //a.duration=1000
        //a.startOffset=200
        //a.repeatCount=Animation.INFINITE
        //a.repeatMode=Animation.REVERSE
        //iv.startAnimation(a)
        b.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.blinkdemo)
            iv.startAnimation(a)
        }
        r.setOnClickListener {
            val b=AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
            iv.startAnimation(b)
        }
        bn.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
            iv.startAnimation(a)
        }
        fin.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
            iv.startAnimation(a)
        }
        fout.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.fade_out)
            iv.startAnimation(a)
        }
        move.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.move)
            iv.startAnimation(a)
        }
        flip.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.flip)
            iv.startAnimation(a)
        }
        zin.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in)
            iv.startAnimation(a)
        }
        zout.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_out)
            iv.startAnimation(a)
        }
        zr.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.zoomrotate)
            iv.startAnimation(a)
        }
        seq.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.sequential)
            iv.startAnimation(a)
        }
        sUp.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up)
            iv.startAnimation(a)
        }
        sDn.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.slide_down)
            iv.startAnimation(a)
        }
        sLeft.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left)
            iv.startAnimation(a)
        }
        sRight.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right)
            iv.startAnimation(a)
        }
        sideSlide.setOnClickListener {
            val a=AnimationUtils.loadAnimation(applicationContext, R.anim.sideslide)
            iv.startAnimation(a)
        }
    }
}