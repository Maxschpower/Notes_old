package com.nnnshei.notes.ui.notes

import com.nnnshei.notes.model.Note
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface NotesView : MvpView {
    fun loadData(data: List<Note>)
    fun openNewScreen(id: Int)
}