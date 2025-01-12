package com.example.roompersisntance.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val noteDatabase = NoteDatabase.getDatabase(application)
    private val noteDao = noteDatabase.noteDao()

    private val _allNotes = MutableLiveData<List<Note>>()
    val allNotes: LiveData<List<Note>> = _allNotes

    init {
        fetchNotes()
    }

    private fun fetchNotes() {
        viewModelScope.launch{
            try {
                val notes = noteDao.getAllNotes()
                _allNotes.postValue(notes)
            }catch (e: Exception){
                _allNotes.postValue(emptyList())
            }
        }
    }
}
