package com.rex.yangtzeu;

import android.app.Application;

public class Yangtzeu extends Application {
    private static Yangtzeu instance;

    public static Yangtzeu getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}