package com.nnnshei.notes.ui

import androidx.fragment.app.Fragment
import com.nnnshei.notes.ui.note.NoteFragment
import com.nnnshei.notes.ui.notes.NotesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object NotesScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = NotesFragment()
    }

    class NoteScreen(private val id: Int) : SupportAppScreen() {
        override fun getFragment(): Fragment = NoteFragment.newInstance(id)
    }

}