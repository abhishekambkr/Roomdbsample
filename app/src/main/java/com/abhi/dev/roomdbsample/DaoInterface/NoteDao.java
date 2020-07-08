package com.abhi.dev.roomdbsample.DaoInterface;

import androidx.room.Dao;
import androidx.room.Insert;

import com.abhi.dev.roomdbsample.Entities.Note;

@Dao
public interface NoteDao {

    //create methods to insert notes into database
    @Insert
    void insert(Note note);


}

