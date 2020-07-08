package com.abhi.dev.roomdbsample.RoomDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.abhi.dev.roomdbsample.DaoInterface.NoteDao;
import com.abhi.dev.roomdbsample.Entities.Note;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

@Database(entities = Note.class,version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
    //singleton object for Room DB
    //if instance of database exits then it is returned else it will create new instance

    private static volatile NoteRoomDatabase noteRoomInstance;

   public static NoteRoomDatabase getDatabase(final Context context){
        if(noteRoomInstance == null){
            synchronized (NoteRoomDatabase.class){
                if(noteRoomInstance == null){
                    //acquire instance of DB using Room.databaseBuilder()
                    noteRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class, "note_database" )
                            .addMigrations()
                            .build();
                     //note_database
                }
            }
        }
        return noteRoomInstance;
    }




}
