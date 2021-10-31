package com.example.ijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
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
import android.widget.RelativeLayout.LayoutParams;

import org.w3c.dom.Text;


public class Achievements extends AppCompatActivity {

    ArrayList<ProgressBar> progressBars   = new ArrayList();
    ArrayList<TextView>    achievNames    = new ArrayList();
    ArrayList<Integer>     descriptionIDs = new ArrayList();


    int achivAll  = 12;
    int achivDone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        getProgressBars(getWindow().getDecorView());
        setRandomProgress(progressBars);
        setAchivText();
        addAchievDescription();
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
            pbs.get(i).setProgress(new Random().nextInt(100));
    }

    private void getProgressBars(View v)
    {
        ViewGroup viewgroup=(ViewGroup)v;
        for (int i = 0; i < viewgroup.getChildCount(); i++)
        {
            View v1 = viewgroup.getChildAt(i);
            if (v1 instanceof  ViewGroup)   getProgressBars(v1);
            if (v1 instanceof  TextView && v1.getTag() == null)    achievNames.add( (TextView) v1);
            if (v1 instanceof  ProgressBar) progressBars.add( (ProgressBar) v1);
        }

    }


    private void addAchievDescription()
    {
        for(int i = 0; i < progressBars.size(); i++)
        {
            RelativeLayout parent;
            if(progressBars.get(i).getParent() instanceof RelativeLayout)
                parent = (RelativeLayout) progressBars.get(i).getParent();
            else return;

            TextView tv = new TextView(this);
            String txt = "Achiev" + (i+1) + " description text";

            tv.setText(txt);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setTextColor(Color.WHITE);
            //tv.setVisibility(View.GONE);


            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.BELOW, achievNames.get(i).getId());
            //layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

            descriptionIDs.add(tv.getId());

            parent.addView(tv);
        }

        Log.w("DEBUG MESSAGE: ", "TOTAL NUMBER OF IDs = " + descriptionIDs.size());
        for(int i = 0; i < descriptionIDs.size(); i++)
            Log.w("DEBUG MESSAGE: ", "ID: " + descriptionIDs.get(i));

    }

    public void focusOnAchiev(View view)
    {

    }


}