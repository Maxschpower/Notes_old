package com.nnnshei.notes.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import moxy.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layout: Int

    open val activityOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = activityOrientation
        setContentView(layout)
        init()
    }

    open fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
