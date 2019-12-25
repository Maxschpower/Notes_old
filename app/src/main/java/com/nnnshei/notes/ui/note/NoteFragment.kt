package com.nnnshei.notes.ui.note

import android.os.Bundle
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.model.Note
import com.nnnshei.notes.presenter.note.NotePresenter
import com.nnnshei.notes.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_note.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NoteFragment : BaseFragment(), NoteView {
    override val layout = R.layout.fragment_note

    @InjectPresenter
    lateinit var presenter: NotePresenter

    @ProvidePresenter
    fun providePresenter() = NotePresenter(NoteApplication.getDatabase().noteDao())

    companion object {
        private const val EXTRA_KEY = "ID"

        fun newInstance(id: Int) = NoteFragment().apply {
            arguments = Bundle().apply {
                putInt(EXTRA_KEY, id)
            }
        }
    }

    private val id by lazy {
        arguments?.getInt(EXTRA_KEY)
    }

    override fun init() {
        makeToast("NoteActivity id:${id}")
        id?.let { presenter.onLoadNote(it) }
        btnBack.setOnClickListener {
            presenter.onBackClicked()
        }
        btnDelete.setOnClickListener {
            id?.let { it1 -> presenter.onDeleteNoteClicked(it1) }
        }
        btnSave.setOnClickListener {
            id?.let { it1 ->
                presenter.onSaveNoteClicked(
                    it1,
                    textNote.text.toString(),
                    System.currentTimeMillis()
                )
            }
        }
    }

    override fun onNoteDelete() {
        makeToast("Заметка удалена")
    }

    override fun onNoteSave() {
        makeToast("Заметка сохранена")
    }

    override fun onNoteLoad(note: Note) {
        textNote.setText(note.text)
    }
}