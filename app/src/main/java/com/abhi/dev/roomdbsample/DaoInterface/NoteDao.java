package com.abhi.dev.roomdbsample.DaoInterface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.abhi.dev.roomdbsample.Entities.Note;

import java.util.List;

@Dao
public interface NoteDao {

    //create methods to insert notes into database
    @Insert
    void insert(Note note);

    //method to fetch all words using livedata any update in db reflects here
    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT * FROM notes WHERE id=:noteId")
    LiveData<Note> getNote(String noteId);

    @Update
    void update(Note note);

    @Delete
    int delete(Note note);

}

