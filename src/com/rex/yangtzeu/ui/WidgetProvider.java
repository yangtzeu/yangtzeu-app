/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.ui;

import java.util.Date;  

import com.rex.yangtzeu.utils.Timetable;
import com.rex.yangtzeu.R;

import android.appwidget.AppWidgetManager;  
import android.appwidget.AppWidgetProvider;  
import android.content.Context;  
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {  
        final int N = appWidgetIds.length;  
        for (int i=0; i<N; i++) {  
            int appWidgetId = appWidgetIds[i];  
            updateAppWidget(context, appWidgetManager, appWidgetId);  
        }  
    }
        
    public void onDeleted(Context context, int[] appWidgetIds) {  
    }  
    
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,  
            int appWidgetId) {  
        CharSequence text;  
        java.text.DateFormat df = new java.text.SimpleDateFormat("hh:mm:ss");  
        text = Timetable.now_state() + "\nTime:" + df.format(new Date());  
          
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_normal);  
        views.setTextViewText(R.id.appwidget_text, text);  
        appWidgetManager.updateAppWidget(appWidgetId, views);  
    }  
  
}
