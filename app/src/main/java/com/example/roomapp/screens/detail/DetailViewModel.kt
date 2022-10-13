package com.example.roomapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapp.REPOSITORY
import com.example.roomapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() -> Unit ) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
}
