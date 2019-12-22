package com.nnnshei.notes.presenter.note

import com.nnnshei.notes.model.Note
import com.nnnshei.notes.model.NoteDao
import com.nnnshei.notes.presenter.BasePresenter
import com.nnnshei.notes.ui.note.NoteView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
class NotePresenter(private val dao: NoteDao) : BasePresenter<NoteView>() {

    fun onDeleteNoteClicked(id: Int) {
        dao.delete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onNoteDelete()
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun onSaveNoteClicked(id: Int, text: String, time: Long) {
            dao.update(Note(id, text, time))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.onNoteSave()
                }, {
                    it.printStackTrace()
                })
                .untilDestroy()
    }

    fun loadNote(id: Int) {
        if (id == -1) return
        dao.loadById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onNoteLoaded(it)
            }, {
                it.printStackTrace()
            })
            .untilDestroy()

    }
}