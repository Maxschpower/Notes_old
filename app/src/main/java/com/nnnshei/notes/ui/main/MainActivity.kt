package com.nnnshei.notes.ui.main

import android.content.Intent
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.presenter.main.MainPresenter
import com.nnnshei.notes.ui.BaseActivity
import com.nnnshei.notes.ui.note.NoteActivity
import com.nnnshei.notes.ui.recycler.NoteApdapter
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : BaseActivity(), MainView {
    override val layout = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter(NoteApplication.getDatabase().noteDao())

    override fun init() {
        makeToast("MainActivity")
        btnNew.setOnClickListener {
            presenter.onCreateNoteClicked()
        }
        btnLoad.setOnClickListener {
            presenter.onLoadNoteClicked(noteFind.text.toString().toInt())
        }
    }

    override fun onNoteCreated() {
        startActivity(Intent(this, NoteActivity::class.java))
    }

    override fun onNoteLoad() {
        startActivity(Intent(this, NoteActivity::class.java))
    }
}