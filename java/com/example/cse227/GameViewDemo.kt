package com.example.cse227

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View

class GameViewDemo(context: Context): View(context) {
    var bg:Bitmap=BitmapFactory.decodeResource(resources, R.drawable.back)
    var mario:Bitmap=BitmapFactory.decodeResource(resources, R.drawable.mario)
    var bird:Bitmap=BitmapFactory.decodeResource(resources, R.drawable.bird)
    var x = 150
    var y = 20
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val r1 = Rect(0,0,bg.width, bg.height)
        val r2 = Rect(0,0,canvas!!.width, canvas.height)
        canvas.drawBitmap(bg, r1, r2, null)
        var h = canvas.height-mario.height - 230
        canvas.drawBitmap(mario, 0f+y, h.toFloat()-x , null)
        canvas.drawBitmap(bird, 900f-y, (h+150).toFloat()-x, null)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN ->
                startimage()
            MotionEvent.ACTION_UP ->
                stopimage()
        }
        return true
    }
    fun stopimage() {
        x = x-200
        invalidate()
    }
    fun startimage() {
        x = x + 200
        y=y+50
        invalidate()
    }
}