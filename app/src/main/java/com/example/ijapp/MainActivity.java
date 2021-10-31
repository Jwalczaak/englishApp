package com.example.ijapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Console;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchActivity(View view){
        String sID;

        if (view.getId() == View.NO_ID) return;
        else sID = view.getResources().getResourceName(view.getId());

        int lastSlash = sID.lastIndexOf('/');
        sID = sID.substring(lastSlash+1, sID.length());

        Log.d("ID is: ", sID );

        switch (sID)
        {
            case "start":

                break;
            case "challenge":

                break;
            case "achievements":
                startActivity(new Intent (this, Achievements.class));
                break;

            case "settings":
                startActivity(new Intent (this, Settings.class));
                break;

            case "rank":

                break;

            default:
                break;

        }

    }

}