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

import org.apache.commons.httpclient.HttpClient;
import com.rex.yangtzeu.sqlite.Sql;
import android.app.Application;
import android.content.Intent;

public class Yangtzeu extends Application {
	private static Yangtzeu instance;
	private static Sql db;
	private static HttpClient client = new HttpClient();

	public static String jwc_login_viewstate = null;
	public static String jwc_login_eventvalidation = null;
	public static String[] sl_array = null;

	public static Yangtzeu getInstance() {
		return instance;
	}

	public static Sql getDB() {
		return db;
	}
	
	public static HttpClient getHttpClient(){
		return client;
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

	}

}