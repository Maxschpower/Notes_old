package com.nnnshei.notes.ui.main

import com.nnnshei.notes.NoteApplication
import com.nnnshei.notes.R
import com.nnnshei.notes.presenter.main.MainPresenter
import com.nnnshei.notes.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : BaseActivity(), MainView {
    override val layout = R.layout.activity_main

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter(NoteApplication.getDatabase().noteDao())

    override fun init() {
        makeToast("Jopa")
        btnNew.setOnClickListener {
            presenter.onCreateNoteClicked("asd")
//            startActivity(Intent(this, NoteActivity::class.java))
        }
    }


}