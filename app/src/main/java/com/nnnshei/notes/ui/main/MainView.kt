package com.nnnshei.notes.ui.main

import com.nnnshei.notes.model.Note
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun onNoteCreated()
    fun onNoteLoad()
    fun loadData(data: List<Note>)
}