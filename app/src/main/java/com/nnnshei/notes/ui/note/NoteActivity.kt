package com.nnnshei.notes.ui.note

import android.widget.Toast
import com.nnnshei.notes.R
import com.nnnshei.notes.ui.BaseActivity

abstract class NoteActivity: BaseActivity() {
    override val layout: Int = R.layout.fragment_note
    override fun init() {
        Toast.makeText(this,"Note activity", Toast.LENGTH_SHORT).show()

    }

}