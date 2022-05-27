package com.neeraj.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteEntity : NoteEntity)

    @Delete
    suspend fun delete(noteEntity : NoteEntity)

    @Query("SELECT * from note_table order by id ASC")
    fun getAllNotes() : LiveData<List<NoteEntity>>

}