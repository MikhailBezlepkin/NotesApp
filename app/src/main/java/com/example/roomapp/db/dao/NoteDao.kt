package com.example.roomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.*
import com.example.roomapp.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(viewModel: NoteModel)

    @Query("SELECT * from note_table")
     fun getAllNotes(): LiveData<List<NoteModel>>
}