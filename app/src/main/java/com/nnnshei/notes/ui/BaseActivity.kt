package com.nnnshei.notes.ui

import android.os.Bundle
import android.widget.Toast
import moxy.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layout: Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        init()
    }

    open fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
