package com.example.ijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Achievements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        setAchivText();

    }

    void setAchivText()
    {
        int achivAll = 100;
        int achivDone = 0;
        TextView achivCount = (TextView) findViewById(R.id.achievementsCount);
        String achivCountText = "Zdobyłeś już " + achivDone + " osiągnięć z " + achivAll;
        achivCount.setText(achivCountText);
    }
}