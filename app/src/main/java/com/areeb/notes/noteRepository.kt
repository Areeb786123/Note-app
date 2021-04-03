package com.areeb.notes

import androidx.lifecycle.LiveData

class noteRepository(private val noteDao: Dao) {
    val allNotes :LiveData<List<Notes>> = noteDao.getAllNotes()

    suspend fun insert(notes: Notes){
        noteDao.insert(notes)
    }

    suspend fun delete(notes: Notes){
        noteDao.delete(notes)
    }
}