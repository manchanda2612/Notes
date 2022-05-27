package com.neeraj.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(application : Application) : AndroidViewModel(application) {

    private val noteRepository : NoteRepository
    val allNotes : LiveData<List<NoteEntity>>

    init {

        val noteDao = NoteDatabase.getInstance(application).getNoteDao()
        noteRepository = NoteRepository(noteDao)
        allNotes = noteRepository.getAllNotes
    }


    fun deleteNote (note : NoteEntity) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun insertNote (note : NoteEntity) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }
}