package com.abhi.dev.roomdbsample;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import android.util.Log;

import com.abhi.dev.roomdbsample.DaoInterface.NoteDao;
import com.abhi.dev.roomdbsample.Entities.Note;
import com.abhi.dev.roomdbsample.RoomDatabase.NoteRoomDatabase;

public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();

    //instance of db to use here
    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;


    public NoteViewModel(@NonNull Application application) {
        super(application);

        //initialising dao n db
        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();


    }

    //to create wrapper for insert of data in NoteViewModel
    public void insert(Note note){
        new  InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");

    }


    private class InsertAsyncTask extends AsyncTask<Note,Void,Void> {

        NoteDao mNoteDao;

        public InsertAsyncTask(NoteDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            mNoteDao.insert(notes[0]);

            return null;
        }
    }
}
