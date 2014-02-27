package com.rex.yuol.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

public class Net {
	/**
	 * ´´½¨AsyncHttpClient
	 * @param context
	 * @return
	 */
	public static AsyncHttpClient create_async_http(Context context) {
		AsyncHttpClient client;
		client = new AsyncHttpClient();
		PersistentCookieStore myCookieStore = new PersistentCookieStore(context);
		client.setCookieStore(myCookieStore);
		return client;
	}
}
