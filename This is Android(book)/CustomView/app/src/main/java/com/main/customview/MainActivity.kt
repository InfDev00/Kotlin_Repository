package com.main.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.main.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val customView = CustomView("hello, Kotlin", this)
        binding.frameLayout.addView(customView)
    }
}

class CustomView(text: String, context: Context): View(context) {
    val text: String
    init {
        this.text = text
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100f

        val blue = Paint()
        blue.style = Paint.Style.FILL
        blue.color = Color.BLUE

        val red = Paint()
        red.style = Paint.Style.STROKE
        red.color = Color.RED

        canvas?.drawCircle(400f, 400f, 50f, red)
        canvas?.drawCircle(150f, 300f, 100f, blue)
        canvas?.drawText(text, 0f, 100f, paint)
    }
}