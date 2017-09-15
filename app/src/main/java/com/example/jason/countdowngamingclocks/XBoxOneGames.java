package com.example.jason.countdowngamingclocks;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XBoxOneGames extends AppCompatActivity {

    private TextView txtCodWWII;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playstation4_games);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.headerlayout);
        countDownStart();
    }
    public void countDownStart()
    {
        //variables for months, days, hours, and seconds calculations
        final int iMonths = 1036800000, iDays = 86400000,iHours = 3600000,
                iMinutes = 60000, iSeconds = 60000;
        //object for the Cod WWII textView
        txtCodWWII = (TextView) findViewById(R.id.txtGame1);
        handler = new Handler();
        runnable = new Runnable()
        {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    // Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2017-10-08");
                    Date currentDate = new Date();
                    //Ths if statement converts the milliseconds till launch date to
                    // months days hours minutes and seconds
                    if (!currentDate.after(futureDate))
                    {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long months = diff / iMonths;
                        diff -= diff / iMonths;
                        long days = diff / iDays;
                        diff -= days * iDays;
                        long hours = diff / iHours;
                        diff -= hours * iHours;
                        long minutes = diff / iMinutes;
                        diff -= minutes * iSeconds;
                        long seconds = diff / 1000;
                        //prints the countdown clock till launch to the cod textView
                        txtCodWWII.setText(months + " Months "  + days + " Days " + hours + " Hours " + minutes + " Min " + seconds + " sec");
                    }
                    else
                    {
                        //if the reached launch day change the textView to day launch day
                        LaunchDay();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
    //method to change Cod textView
    public void LaunchDay()
    {
        txtCodWWII.setText("Launch Day!");
    }
}