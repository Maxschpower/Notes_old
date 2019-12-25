package com.nnnshei.notes.ui.notes

import com.nnnshei.notes.model.Note
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface NotesView : MvpView {
    fun loadData(data: List<Note>)
}