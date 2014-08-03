/**
 * 长大长新-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class YuService extends Service {
	private static final String TAG = "rex";
	public static final String ACTION = "com.rex.yangtzeu.YuService";
	Timer timer;

	@Override
	public void onCreate() {
		Log.v(TAG, "ServiceDemo onCreate");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.v(TAG, "ServiceDemo onStart");
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v(TAG, "ServiceDemo onStartCommand");

		// updateWeather();
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// 定时更新
				// String jsonString = getWeather();
				// 发送广播
//				Intent intent = new Intent();
//				intent.setAction(ACTION);
				// intent.putExtra("jsonstr", jsonString);
//				sendBroadcast(intent);
				// Message msg = handler.obtainMessage();
				// msg.what = UPDATAWEATHER;
				// handler.sendMessage( msg );
				// Log.v("srv", "service update. rex");


			}
		}, 0, 20 * 1000);// 20s

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG, "ServiceDemo onBind");
		return null;
	}
}