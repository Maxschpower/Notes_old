package com.nnnshei.notes.presenter

import com.nnnshei.notes.NoteApplication
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<T : MvpView> : MvpPresenter<T>() {

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.untilDestroy() = compositeDisposable.add(this)

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    open fun onBackClicked() {
        NoteApplication.router.exit()
    }
}