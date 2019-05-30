package com.androidatelier.fillmyglass.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class GlassView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

  private val glassPath: Path by lazy {
    Path().apply {
      moveTo(0f,0f)
      lineTo(0f, height.toFloat())
      lineTo(width.toFloat(), height.toFloat())
      lineTo(width.toFloat(), 0f)
    }
  }

  private val glassPaint = Paint().apply {
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = 8.0f
  }

  private val liquidPaint = Paint().apply {
    color = Color.CYAN
    style = Paint.Style.FILL
  }

  override fun onDraw(canvas: Canvas?) {
    canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), liquidPaint)
    canvas?.drawPath(glassPath, glassPaint)
  }
}