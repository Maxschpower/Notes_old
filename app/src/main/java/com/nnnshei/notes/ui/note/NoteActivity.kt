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

    private val noteId: Int by lazy {
        intent.getIntExtra(INTENT_NOTE_KEY, -1)
    }

    @InjectPresenter
    lateinit var presenter: NotePresenter

    @ProvidePresenter
    fun providePresenter() = NotePresenter(NoteApplication.getDatabase().noteDao())

    override fun init() {
        presenter.loadNote(noteId)
        makeToast("NoteActivity")
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnDelete.setOnClickListener {
            //            presenter.onDeleteNoteClicked()
        }
        btnSave.setOnClickListener {
            presenter.onSaveNoteClicked(
                noteId,
                textNote.text.toString(),
                System.currentTimeMillis()
            )
        }
    }

    override fun onNoteDelete() {
        makeToast("Заметка удалена")
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onNoteSave() {
        makeToast("Заметка сохранена")
    }

    override fun onNoteLoaded(note: Note) {
        textNote.setText(note.text)
    }

    companion object {
        const val INTENT_NOTE_KEY = "id"
    }
}