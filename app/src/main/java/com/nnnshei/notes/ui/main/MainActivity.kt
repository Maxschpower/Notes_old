package com.nnnshei.notes.ui.main

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.model.Note
import com.nnnshei.notes.presenter.main.MainPresenter
import com.nnnshei.notes.ui.BaseActivity
import com.nnnshei.notes.ui.note.NoteActivity
import com.nnnshei.notes.ui.recycler.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : BaseActivity(), MainView {

    override val layout = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter(NoteApplication.getDatabase().noteDao())

    private val adapter = NoteAdapter {
        onNoteLoad(it.id)
    }

    override fun init() {
        requestedOrientation =(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        rec.layoutManager = LinearLayoutManager(this)
        rec.adapter = adapter
        btnNew.setOnClickListener {
            presenter.onCreateNoteClicked()
        }
        btnLoad.setOnClickListener {
            onNoteLoad(noteFind.text.toString().toInt())
        }
    }

    override fun onNoteCreated() {
        startActivity(Intent(this, NoteActivity::class.java))
    }

    override fun onNoteLoad(id: Int) {
        val intent = Intent(this, NoteActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }

    override fun loadData(data: List<Note>) {
        adapter.bindData(data)
    }
}