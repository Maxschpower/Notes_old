package com.nnnshei.notes.ui.note

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface NoteView: MvpView {
    fun onNoteDelete()
    fun onNoteSave()
}