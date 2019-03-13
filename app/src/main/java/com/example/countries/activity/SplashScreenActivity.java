package com.example.countries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.countries.R;
import com.example.countries.activity.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {
    //to set length of splash screen to 10 seconds
    private final int SPLASH_DISPLAY_LENGTH =10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //to display splash screen with delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}//end of SplashScreenActivity class