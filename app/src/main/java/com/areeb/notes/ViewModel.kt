package com.areeb.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Files.delete

abstract class ViewModel(application: Application):AndroidViewModel(application) {

    abstract val repository:noteRepository
    val allNotes:LiveData<List<Notes>>

    init {

        val dao=NoteDatabase.getDatabase(application).getNoteDao()
        val repository=noteRepository(dao)
        allNotes=repository.allNotes

    }

    fun deleteNote(note:Notes)= viewModelScope.launch  (Dispatchers.IO){
       repository.delete(note)
    }

    fun insertNote(note:Notes)= viewModelScope.launch  (Dispatchers.IO){
        repository.insert(note)
    }
}
