package com.abhi.dev.roomdbsample;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    public static final String NOTE_ADDED = "new_note";

    private EditText eNewnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        eNewnote = findViewById(R.id.edt1);
        Button btnadd = findViewById(R.id.btn_add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                if(TextUtils.isEmpty(eNewnote.getText())){
                    setResult(RESULT_CANCELED,result);
                }else{
                    String note = eNewnote.getText().toString();
                    result.putExtra(NOTE_ADDED,note);
                    setResult(RESULT_OK,result);
                }
                finish();
            }
        });
    }


}
