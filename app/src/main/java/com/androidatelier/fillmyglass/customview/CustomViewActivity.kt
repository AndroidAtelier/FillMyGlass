package com.androidatelier.fillmyglass.customview

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.androidatelier.fillmyglass.R
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_custom_view)

    val animator = ValueAnimator.ofFloat(0f, 1f).apply {
      duration = 5000
      addUpdateListener {
        Log.d("Hi", it.animatedFraction.toString())
        glass.percentage = it.animatedFraction
      }
    }

    glass.setOnClickListener {
      when {
        animator.isPaused -> animator.resume()
        animator.isRunning -> animator.pause()
        else ->  {
          glass.percentage = 0f
          animator.start()
        }
      }
    }
  }
}
