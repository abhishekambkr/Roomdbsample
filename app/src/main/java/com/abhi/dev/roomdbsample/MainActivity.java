package com.abhi.dev.roomdbsample;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abhi.dev.roomdbsample.Entities.Note;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    private NoteViewModel noteViewModel;
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,NewNoteActivity.class);
               startActivityForResult(intent,NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){

            //insert note code
            final String note_id = UUID.randomUUID().toString();
            Note note = new Note(note_id,data.getStringExtra(NewNoteActivity.NOTE_ADDED));

            //to call insert function
            noteViewModel.insert(note);

            Toast.makeText(getApplicationContext(),"SAVED",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(),"NOT SAVED",Toast.LENGTH_SHORT).show();
        }
    }
}
