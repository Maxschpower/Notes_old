package com.nnnshei.notes.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class),version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}