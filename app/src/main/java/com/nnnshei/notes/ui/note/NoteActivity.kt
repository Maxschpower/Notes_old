package com.nnnshei.notes.ui.note

import android.content.Intent
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.model.Note
import com.nnnshei.notes.presenter.note.NotePresenter
import com.nnnshei.notes.ui.BaseActivity
import com.nnnshei.notes.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_note.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NoteActivity : BaseActivity(), NoteView {
    override val layout = R.layout.fragment_note

    @InjectPresenter
    lateinit var presenter: NotePresenter

    @ProvidePresenter
    fun providePresenter() = NotePresenter(NoteApplication.getDatabase().noteDao())

    private val id by lazy {
        intent.getIntExtra(MainActivity.EXTRA_KEY, -1)
    }

    override fun init() {
        makeToast("NoteActivity id:${id}")
        presenter.onLoadNote(id)
        btnBack.setOnClickListener {
            finish()
        }
        btnDelete.setOnClickListener {
            presenter.onDeleteNoteClicked(id)
        }
        btnSave.setOnClickListener {
            presenter.onSaveNoteClicked(id, textNote.text.toString(), System.currentTimeMillis())
        }
    }

    override fun onNoteDelete() {
        finish()
        makeToast("Заметка удалена")
    }

    override fun onNoteSave() {
        makeToast("Заметка сохранена")
    }

    override fun onNoteLoad(note: Note) {
        textNote.setText(note.text)
    }
}