package com.mpcoding.sampledialogactivity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView


class DialogActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        val screenWidth = resources.displayMetrics.widthPixels
        val layout = findViewById<View>(R.id.layout) as FrameLayout
        layout.layoutParams.width = screenWidth / 3
        layout.layoutParams.height = screenWidth / 3
        layout.requestLayout()
        (findViewById<View>(R.id.text).parent as View).setOnClickListener { finishAfterTransition() }
        findViewById<View>(R.id.text).setOnClickListener(null)
        val position = intent.getIntExtra("position", 0)
        (findViewById<View>(R.id.text) as TextView).text = "" + position
    }
}
