package com.nnnshei.notes.ui.notes

import androidx.recyclerview.widget.LinearLayoutManager
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.model.Note
import com.nnnshei.notes.presenter.notes.NotesPresenter
import com.nnnshei.notes.ui.BaseFragment
import com.nnnshei.notes.ui.recycler.NoteAdapter
import kotlinx.android.synthetic.main.fragment_notes.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NotesFragment : BaseFragment(), NotesView {

    override val layout = R.layout.fragment_notes

    @InjectPresenter
    lateinit var presenter: NotesPresenter

    @ProvidePresenter
    fun providePresenter() = NotesPresenter(NoteApplication.getDatabase().noteDao())

    private val adapter = NoteAdapter {
        presenter.onNoteClicked(it.id)
    }

    override fun init() {
        rec.layoutManager = LinearLayoutManager(requireContext())
        rec.adapter = adapter

        btnNew.setOnClickListener {
            presenter.onCreateNoteClicked()
        }

        btnLoad.setOnClickListener {
            noteFind.text.toString().toIntOrNull()?.let(presenter::onNoteClicked)
        }
    }

    override fun loadData(data: List<Note>) {
        adapter.bindData(data)
    }
}