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

public class Achievements extends AppCompatActivity {

    ArrayList<ProgressBar> progressBars;
    int achivAll = 12;
    int achivDone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getProgressBars();
        setAchivText();

    }

    void setAchivText()
    {
        TextView achivCount = (TextView) findViewById(R.id.achievementsCount);
        String achivCountText = "Zdobyłeś już " + achivDone + " osiągnięć z " + achivAll;
        achivCount.setText(achivCountText);
    }

    void getProgressBars()
    {
        TableLayout viewGroup = findViewById(R.id.achievTable);
        for(int index = 0; index < ((ViewGroup) viewGroup).getChildCount(); index++) {
            View nextChild = ((ViewGroup) viewGroup).getChildAt(index);
            if(nextChild instanceof TableRow)
            {
                TableRow tableRow = (TableRow) nextChild;
                for(int i = 0; i < ((ViewGroup) tableRow).getChildCount(); i++)
                {
                    View rl = ((ViewGroup) tableRow).getChildAt(i);
                    for(int j = 0; j < ((ViewGroup) rl).getChildCount(); j++)
                    {
                        View pb =  ((ViewGroup) rl).getChildAt(index);
                        if(pb instanceof  ProgressBar)
                        {
                            Log.w("Got ", "______________________________________________________________________Progress");
                        }
                    }
                }
            }
            else break;

        }
    }
}