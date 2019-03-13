package com.example.countries.activity;

import android.app.Application;

import io.paperdb.Paper;

public class BaseApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        //to initialise the paperDB
        Paper.init(this);
    }
}//end of BaseApplication class
