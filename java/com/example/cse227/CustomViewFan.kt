package com.example.cse227

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View

class CustomViewFan(context: Context?) : View(context) {
    var p: Paint=Paint()
    var x = 100
    var y=20;
    var a = 900
    var q: Paint = Paint()
    var r: Paint = Paint()
    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.BLACK)
        p.color = Color.GRAY
        q.color = Color.CYAN
        r.color = Color.MAGENTA
        canvas.drawOval(200f,(x + 900).toFloat(),500f,(x+500).toFloat(),r)
        canvas.drawRect(100f+y, 100f, 500f+y, 500f, q)
        p.color = Color.GRAY
        canvas.drawArc(500f, 500f, 800f, 800f,
            x.toFloat(),
            30f,true, p )
        canvas.drawArc(500f, 500f, 800f, 800f,
            (x + 120).toFloat(),
            30f, true, p)
        canvas.drawArc(500f, 500f, 800f, 800f,
            (x + 240).toFloat(),
            30f, true, p)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN ->
                startFan()
            MotionEvent.ACTION_UP -> stopFan()
        }
        return true
    }
    fun stopFan() {
    }
    fun startFan() {
        x = x + 5
        y=y+10
        a = a+20
        invalidate()
    }


}