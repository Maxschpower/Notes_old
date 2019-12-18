package com.nnnshei.notes.model

import androidx.room.*
import io.reactivex.Single

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id = :noteId")
    fun loadById(noteId: Int): Single<Note>

    @Insert
    fun insert(note: Note): Single<Unit>

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)
}