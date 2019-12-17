package com.nnnshei.notes.ui.main

import com.nnnshei.notes.R
import com.nnnshei.notes.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layout = R.layout.activity_main

    override fun init() {
        makeToast("Jopa")
        btnEnter.setOnClickListener {

        }
    }
}