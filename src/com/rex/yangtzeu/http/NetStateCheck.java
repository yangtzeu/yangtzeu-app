/**
 * 掌上长大-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rex.yangtzeu.utils.Sql;

public class NetStateCheck {
	private AsyncHttpClient client;

	public NetStateCheck(Context context) {
		client=Net.create_async_http(context);
	}

	public void check_inner_net() {
		this.check_library();
	}

	public void check_jwc() {
		// 教务处状态
		client.get("http://jwc.yangtzeu.edu.cn:8080/login.aspx",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						Sql.kv_set("jwc_state", "true");
					}

					@Override
					public void onFailure(Throwable error, String content) {
						Sql.kv_set("jwc_state", "false");
					}
				});
	}

	public void check_library() {
		// 获取图书馆当前状态
		client.get("http://10.203.1.110/enter.html",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						Sql.kv_set("inner_net", "true");
						Sql.kv_set("library_state", "true");
					}

					@Override
					public void onFailure(Throwable error, String content) {
						Sql.kv_set("inner_net", "false");
						Sql.kv_set("library_state", "false");
					}
				});
	}
}
