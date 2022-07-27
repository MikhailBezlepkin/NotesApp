package com.example.roomapp.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapp.REPOSITORY
import com.example.roomapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel:ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit ) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
}