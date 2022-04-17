package com.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.model.Notes

@Dao
interface NotesDao {
    @Query("SELECT*FROM NOTES")
    fun getNotes() : LiveData<List<Notes>>

    @Query("SELECT*FROM NOTES WHERE priority =3")
    fun getHighNotes() : LiveData<List<Notes>>

    @Query("SELECT*FROM NOTES WHERE priority = 2")
    fun getMediumNotes() : LiveData<List<Notes>>

    @Query("SELECT*FROM NOTES WHERE priority= 1")
    fun getLowNotes() : LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM NOTES WHERE id = :id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: Notes)
}