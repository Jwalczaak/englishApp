package com.example.ijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class Achievements extends AppCompatActivity {

    ArrayList<ProgressBar> progressBars = new ArrayList();
    int achivAll = 12;
    int achivDone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getProgressBars(getWindow().getDecorView());
        setRandomProgress(progressBars);
        setAchivText();

    }

    void setAchivText()
    {
        TextView achivCount = (TextView) findViewById(R.id.achievementsCount);
        String achivCountText = "Zdobyłeś już " + achivDone + " osiągnięć z " + achivAll;
        achivCount.setText(achivCountText);
    }

    private void setRandomProgress(ArrayList<ProgressBar> pbs)
    {
        if(pbs.isEmpty()) return;
        for(int i = 0; i < pbs.size(); i++)
        {
            pbs.get(i).setProgress(new Random().nextInt(100));
        }
    }

    private void getProgressBars(View v) {
        ViewGroup viewgroup=(ViewGroup)v;
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            View v1 = viewgroup.getChildAt(i);
            if (v1 instanceof ViewGroup) getProgressBars(v1);
            if (v1 instanceof  ProgressBar) progressBars.add( (ProgressBar) v1);
        }
    }


}