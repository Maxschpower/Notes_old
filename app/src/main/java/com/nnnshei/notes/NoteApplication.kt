package com.nnnshei.notes

import android.app.Application
import androidx.room.Room
import com.nnnshei.notes.model.AppDatabase
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class NoteApplication : Application() {

    companion object {
        private lateinit var database: AppDatabase
        fun getDatabase() = database

        private val cicerone = Cicerone.create()

        val navigatorHolder: NavigatorHolder = cicerone.navigatorHolder

        val router: Router = cicerone.router
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "notesbd")
            .fallbackToDestructiveMigration().build()

    }

}