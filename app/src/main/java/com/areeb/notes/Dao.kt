package com.areeb.notes

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(note :Notes)

    @Delete
    suspend fun delete(note:Notes)


    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes():LiveData<List<Notes>>
}