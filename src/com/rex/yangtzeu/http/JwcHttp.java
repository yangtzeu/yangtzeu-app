package com.rex.yangtzeu.http;

import org.apache.http.client.HttpResponseException;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.rex.yangtzeu.Yangtzeu;
import com.rex.yangtzeu.regex.JwcRegex;
import com.rex.yangtzeu.sqlite.ComDB;
import com.rex.yangtzeu.utils.EncrypAES;

public class JwcHttp {
	public static boolean jwc_login() { // there should be rewrite
		String student_number = ComDB.kv_get("student_number");
		String student_password = EncrypAES.decrypt(ComDB
				.kv_get("student_password"));

		String viewstate = Yangtzeu.jwc_login_viewstate;
		String eventvalidation = Yangtzeu.jwc_login_eventvalidation;

		final RequestParams params = new RequestParams();
		params.put("txtUid", student_number);
		params.put("txtPwd", student_password);
		params.put("selKind", "1");
		params.put("__VIEWSTATE", viewstate);
		params.put("__EVENTVALIDATION", eventvalidation);

		Yangtzeu.getHttpClient().post(
				"http://jwc.yangtzeu.edu.cn:8080/login.aspx", params,
				new AsyncHttpResponseHandler() {
					@Override
					public void onStart() {
						setCharset("GB2312");
					}

					@Override
					public void onSuccess(String response) {
						if (!JwcRegex.is_not_login(response)) {
							ComDB.kv_set("login_state", "true");
							int rst = response.indexOf("201103233");
							Toast.makeText(Yangtzeu.getInstance(),
									"login:" + rst, Toast.LENGTH_LONG).show();

						}
					}

					@Override
					public void onFailure(Throwable error, String content) {
						HttpResponseException hre = (HttpResponseException) error;
						int statusCode = hre.getStatusCode();

						Toast.makeText(
								Yangtzeu.getInstance(),
								"failure:" + statusCode + "\n"
										+ params.toString(), Toast.LENGTH_LONG)
								.show();
						ComDB.kv_set("login_state", "false");
					}
				});
		return true;
	}
}
