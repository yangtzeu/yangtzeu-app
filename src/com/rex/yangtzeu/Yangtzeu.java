/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu;

import com.rex.yangtzeu.utils.Sql;

import android.app.Application;

public class Yangtzeu extends Application {
    private static Yangtzeu instance;
    private static Sql db;

    public static Yangtzeu getInstance() {
        return instance;
    }
    
    public static Sql getDB(){
    	return db;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        db=new Sql(this);
        instance = this;
    }
}