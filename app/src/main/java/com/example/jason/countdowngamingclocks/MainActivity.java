package com.example.jason.countdowngamingclocks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    int iIntentRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //onClick for the playstation tab
    public void btn_playstation4_OnClick(View oView)
    {
        startActivityForResult(new Intent("com.example.jason.countdowngamingclocks.playstation4Games"), iIntentRequestCode);
    }
    //onClick for XBoxOneGames
    public void btn_XBoxOne_OnClick(View oView)
    {
        startActivityForResult(new Intent("com.example.jason.countdowngamingclocks.XBoxOneGames"), iIntentRequestCode);
    }
}
