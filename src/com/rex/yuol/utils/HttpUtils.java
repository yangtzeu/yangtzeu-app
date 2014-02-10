package com.rex.yuol.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class HttpUtils extends Thread {
	public InputStream in_stream = null;
	public String url = "";
	public Object callback=null;

	public static String get(String url,Object callback) {
		HttpUtils get_request = new HttpUtils();
		get_request.callback=callback;
		get_request.url = url;
		get_request.start();
		return "";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (this.url == "") {
			return;
		}
		URL url_object;
		try {
			url_object = new URL(this.url);
			HttpURLConnection urlConn = (HttpURLConnection) url_object
					.openConnection();
			urlConn.setConnectTimeout(MAX_PRIORITY * 1000);
			urlConn.setDoInput(true);
			urlConn.setRequestMethod("GET");
			int code = urlConn.getResponseCode();
			if (code == 200) {
				this.in_stream = urlConn.getInputStream();
				Log.i("http", "yes");
				Looper.prepare();
				Toast.makeText((Context)callback, "hi",
						Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("http", e.getMessage() + ":http error.");
		}
	}

}