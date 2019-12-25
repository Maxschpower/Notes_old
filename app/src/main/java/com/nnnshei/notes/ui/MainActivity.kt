package com.nnnshei.notes.ui

import android.os.Bundle
import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : BaseActivity() {

    override val layout: Int = R.layout.activity_main

    private val navigator = SupportAppNavigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NoteApplication.router.navigateTo(Screens.NotesScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        NoteApplication.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        NoteApplication.navigatorHolder.removeNavigator()
    }

    override fun init() {}
}