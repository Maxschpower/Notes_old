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

    @Query ("DELETE FROM note WHERE id=:noteId")
    fun delete(noteId: Int)

    @Update
    fun update(note: Note): Single<Unit>
}