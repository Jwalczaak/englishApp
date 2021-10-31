package com.example.ijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private static final String TAG = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Log.d(TAG, "onCreate: Starting");

        Button btnNavToEdit = (Button) findViewById(R.id.editSettings);

        btnNavToEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClickClicked button editSettings: ");


                Intent intent = new Intent(Settings.this, Edit.class);
                startActivity((intent));
            }
        });
    }
}