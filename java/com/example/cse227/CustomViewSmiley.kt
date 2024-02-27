package com.example.cse227

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CustomViewSmiley (context: Context?) : View(context){
val paint = Paint(Paint.ANTI_ALIAS_FLAG)
val faceColor = Color.YELLOW
val borderSize  = 16.0f
val borderColor = Color.WHITE
val borderSize2  = 12.0f
val borderColor2 = Color.BLACK
var size = 850
private val mouthPath = Path()
override fun onDrawForeground(canvas: Canvas?) {
    super.onDrawForeground(canvas)
    drawFace(canvas)
    drawEyes(canvas)
    drawMouth(canvas)
}
fun drawFace(canvas: Canvas?)
{
    paint.color = faceColor
    paint.style = Paint.Style.FILL
    val radius = size/2f
    canvas?.drawCircle( size/2f+200f, size/2f+200f,
        radius, paint)
    paint.color = borderColor
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = borderSize
    canvas?.drawCircle(size/2f+200f, size/2f+200f, radius-borderSize, paint)
    paint.color = borderColor2
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = borderSize2
    canvas?.drawCircle(size/2f+200f, size/2f+200f, radius-borderSize2, paint)

}
fun drawEyes(canvas: Canvas?){
    paint.color= Color.BLACK
    paint.style = Paint.Style.FILL

    val lefteye = RectF(size*0.32f+200f, size*0.23f+200f, size*0.43f+200f, size*0.50f+200f)
    canvas?.drawOval(lefteye, paint)
    val righteye = RectF(size*0.57f+200f, size*0.23f+200f, size*0.68f+200f, size*0.50f+200f)
    canvas?.drawOval(righteye, paint)
}
fun drawMouth(canvas: Canvas?) {
    mouthPath.moveTo(size * 0.2f+200f, size * 0.7f+200f)
    mouthPath.quadTo(size * 0.50f+200f, size * 0.80f+200f, size * 0.78f+200f, size * 0.70f+200f)
    mouthPath.quadTo(size * 0.50f+200f, size * 0.90f+200f, size * 0.22f+200f, size * 0.70f+200f)
    canvas?.drawPath(mouthPath, paint)
}
}