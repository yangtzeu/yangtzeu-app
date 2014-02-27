package com.rex.yuol;

import java.util.Date;  

import com.rex.yuol.utils.Timetable;

import android.appwidget.AppWidgetManager;  
import android.appwidget.AppWidgetProvider;  
import android.content.Context;  
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
