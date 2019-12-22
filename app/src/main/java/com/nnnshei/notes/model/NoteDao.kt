package com.nnnshei.notes.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Single

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): Single<List<Note>>

    @Query("SELECT * FROM note WHERE id = :noteId")
    fun loadById(noteId: Int): Single<Note>

    @Insert
    fun insert(note: Note): Single<Unit>

    @Query("DELETE FROM note WHERE id=:noteId")
    fun delete(noteId: Int): Single<Unit>

    @Update
    fun update(note: Note): Single<Unit>

    @Query("SELECT * FROM note ORDER BY id DESC LIMIT 1")
    fun getLastNote(): Single<Note>
}