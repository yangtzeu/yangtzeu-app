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

import com.rex.yangtzeu.sqlite.Sql;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

public class Yangtzeu extends Application {
	private static Yangtzeu instance;
	private static Sql db;

	public static String jwc_login_viewstate = null;
	public static String jwc_login_eventvalidation = null;

	public static Yangtzeu getInstance() {
		return instance;
	}

	public static Sql getDB() {
		return db;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		YuException crashHandler = YuException.getInstance();
		// 注册crashHandler
		crashHandler.init(getApplicationContext());

		init();
	}

	private void init() {
		instance = this;
		db = new Sql();
		this.startService(new Intent(YuService.ACTION));

		SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.clear();
		
		net_check();
	}

	/**
	 * 网络检查等初始化
	 */
	private void net_check() {
	}
}