package com.nnnshei.notes.presenter.notes

import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.model.Note
import com.nnnshei.notes.model.NoteDao
import com.nnnshei.notes.presenter.BasePresenter
import com.nnnshei.notes.ui.Screens
import com.nnnshei.notes.ui.notes.NotesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
class NotesPresenter(private val dao: NoteDao) : BasePresenter<NotesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        dao.observeAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(viewState::loadData, Throwable::printStackTrace)
            .untilDestroy()
    }

    fun onNoteClicked(id: Int) {
//        NoteApplication.router.navigateTo(Screens.NoteScreen(id))
        viewState.openNewScreen(id)
    }

    fun onCreateNoteClicked() {
        dao.insert(Note(0, null, System.currentTimeMillis()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.openNewScreen(-1)
                //                NoteApplication.router.navigateTo(Screens.NoteScreen(-1))
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }
}