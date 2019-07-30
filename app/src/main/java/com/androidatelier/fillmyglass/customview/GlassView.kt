package com.androidatelier.fillmyglass.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class GlassView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
  var percentage = 0f
    set(value) {
      field = when {
          (value < 0) -> 0f
          (value > 1) -> 1f
          else -> value
      }
      invalidate()
    }
  private val mStrokeWidth = 8f;

  private val glassPath: Path by lazy {
    Path().apply {
      val cupTop = (OVAL_HEIGHT * height.toFloat())/2f;
      val cupBottom = ((1- OVAL_HEIGHT) * height.toFloat() + height.toFloat())/2f
      moveTo(0f,cupTop)
      lineTo(0f, cupBottom)
      moveTo(width.toFloat(), cupBottom)
      lineTo(width.toFloat(), cupTop)
    }
  }

  private val glassPaint = Paint().apply {
    color = Color.BLACK
    style = Paint.Style.STROKE
    strokeWidth = mStrokeWidth
  }

  private val liquidPaint = Paint().apply {
    color = Color.CYAN
    style = Paint.Style.FILL
  }

  private val ovalTop : RectF by lazy {
    RectF().apply {
      left = 0f
      top = mStrokeWidth/2f
      right = width.toFloat()
      bottom = OVAL_HEIGHT * height.toFloat()
    }
  }

  private val ovalBottom : RectF by lazy {
    RectF().apply {
      left = 0f
      top = (1- OVAL_HEIGHT) * height.toFloat()
      right = width.toFloat()
      bottom = height.toFloat() - mStrokeWidth/2f
    }
  }

  override fun onDraw(canvas: Canvas?) {
    val top = (1 - percentage) * height.toFloat()
    val percentageBottom = 1 - OVAL_HEIGHT/2
    val bottom = height.toFloat() * percentageBottom
    if (percentage > 0f && percentage < percentageBottom) {
      canvas?.drawOval(ovalBottom, liquidPaint)
      canvas?.drawRect(0f, top, width.toFloat(), bottom, liquidPaint )
    } else if ( percentage > percentageBottom) {
      canvas?.drawOval(ovalBottom, liquidPaint)
      val maxTop = OVAL_HEIGHT/2 * height.toFloat();
      canvas?.drawRect(0f, maxTop, width.toFloat(), bottom, liquidPaint )
      canvas?.drawOval(ovalTop, liquidPaint)
    }

    canvas?.drawPath(glassPath, glassPaint)
    canvas?.drawOval(ovalTop, glassPaint)
    canvas?.drawOval(ovalBottom, glassPaint)
  }

  companion object {
    private const val OVAL_HEIGHT = 0.05f;
  }

}