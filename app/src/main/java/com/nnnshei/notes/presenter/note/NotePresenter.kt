package com.nnnshei.notes.presenter.note

import com.nnnshei.notes.NoteApplication
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
                NoteApplication.router.exit()
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun onSaveNoteClicked(id: Int, text: String, time: Long) {
        if (id == -1)
            dao.getLastNote()
                .subscribeOn(Schedulers.io())
                .flatMap { dao.update(it.copy(text = text, time = System.currentTimeMillis())) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.onNoteSave()
                },{
                    it.printStackTrace()
                })
                .untilDestroy()
        else
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

    fun onLoadNote(id: Int) {
        dao.loadById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onNoteLoad(it)
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }
}