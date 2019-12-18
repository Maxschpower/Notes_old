package com.nnnshei.notes.presenter.main

import com.nnnshei.notes.model.Note
import com.nnnshei.notes.model.NoteDao
import com.nnnshei.notes.presenter.BasePresenter
import com.nnnshei.notes.ui.main.MainView

class MainPresenter(private val dao: NoteDao) : BasePresenter<MainView>() {

    fun onCreateNoteClicked(text: String) {
        dao.insert(Note(0, text, System.currentTimeMillis()))
    }

}