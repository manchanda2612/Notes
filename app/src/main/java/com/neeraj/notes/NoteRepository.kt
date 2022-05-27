package com.neeraj.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val getAllNotes : LiveData<List<NoteEntity>> =  noteDao.getAllNotes()

    suspend fun insertNote(noteEntity : NoteEntity) {
        noteDao.insert(noteEntity)
    }

    suspend fun deleteNote(noteEntity: NoteEntity) {
        noteDao.delete(noteEntity)
    }
}