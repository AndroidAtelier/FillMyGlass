package com.androidatelier.fillmyglass.customview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androidatelier.fillmyglass.R
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_custom_view)
    glass.setOnClickListener {
      glass.percentage += 0.1f
    }
  }
}
