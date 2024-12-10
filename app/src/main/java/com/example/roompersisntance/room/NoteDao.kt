package com.example.roompersisntance.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note : note)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id:Int):Note?

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteById(id: Int)
}