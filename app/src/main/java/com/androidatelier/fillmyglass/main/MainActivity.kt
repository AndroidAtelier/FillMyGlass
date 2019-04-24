package com.androidatelier.fillmyglass.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidatelier.fillmyglass.customview.CustomViewActivity
import com.androidatelier.fillmyglass.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    customViewButton.setOnClickListener {
      val startIntent = Intent(this, CustomViewActivity::class.java)
      startActivity(startIntent)
    }
  }
}
