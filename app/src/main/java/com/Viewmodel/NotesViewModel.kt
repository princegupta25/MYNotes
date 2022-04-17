package com.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.DataBase.NotesDatabase
import com.Repositiry.NotesRepository
import com.model.Notes

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val repository:NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
            repository = NotesRepository(dao)
    }
    fun addNotes(notes: Notes){
        return repository.insertNotes(notes)
    }

    fun getLowNotes() : LiveData<List<Notes>> = repository.getLowNotes()

    fun getMediumNotes() : LiveData<List<Notes>> = repository.getMediumNotes()

    fun getHighNotes() : LiveData<List<Notes>> = repository.getHighNotes()


    fun getNotes() : LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id :Int){
        return repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        return repository.updateNotes(notes)
    }


}