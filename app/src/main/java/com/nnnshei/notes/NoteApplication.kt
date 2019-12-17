package com.nnnshei.notes

import android.app.Application
import androidx.room.Room
import com.nnnshei.notes.model.AppDatabase

class NoteApplication : Application() {

    companion object {
        private lateinit var database: AppDatabase
        fun getDatabase() = database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "notesbd").build()
    }

}