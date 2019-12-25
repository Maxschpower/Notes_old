package com.nnnshei.notes.presenter.main

import com.nnnshei.notes.model.Note
import com.nnnshei.notes.model.NoteDao
import com.nnnshei.notes.presenter.BasePresenter
import com.nnnshei.notes.ui.main.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
class MainPresenter(private val dao: NoteDao) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        dao.observeAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(viewState::loadData,Throwable::printStackTrace)
            .untilDestroy()
    }

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
}