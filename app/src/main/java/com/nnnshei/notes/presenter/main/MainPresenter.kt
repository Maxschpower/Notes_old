package com.nnnshei.notes.presenter.main

import com.nnnshei.notes.model.Note
import com.nnnshei.notes.model.NoteDao
import com.nnnshei.notes.presenter.BasePresenter
import com.nnnshei.notes.ui.main.MainView
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
class MainPresenter(private val dao: NoteDao) : BasePresenter<MainView>() {

    fun onCreateNoteClicked() {
        dao.insert(Note(0, null, System.currentTimeMillis()))
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewState.onNoteCreated()
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun onLoadNoteClicked(id: Int) {
        dao.loadById(id)
            .subscribeOn(Schedulers.io())
            .subscribe({
               viewState.onNoteLoad()
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }
}