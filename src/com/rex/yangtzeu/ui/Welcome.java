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

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rex.yangtzeu.config.Urls;
import com.rex.yangtzeu.http.NetStateCheck;
import com.rex.yangtzeu.regex.JwcRegex;
import com.rex.yangtzeu.sqlite.ComDB;
import com.rex.yangtzeu.R;
import com.rex.yangtzeu.Yangtzeu;
import com.rex.yangtzeu.YuService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Toast;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		// ComDB.kv_set("login_state", "false");
		// try {
		// String s=ComDB.kv_get("login_state");
		// Toast.makeText(getApplicationContext(), s,
		// Toast.LENGTH_LONG).show();
		// } catch (Exception e) {
		// Toast.makeText(getApplicationContext(), e.getMessage(),
		// Toast.LENGTH_LONG).show();
		// }
//		int x=1/0;

		new Thread(new Runnable() {
			public void run() {
				deal_sth();
			}
		}).start();

		final View view = View.inflate(this, R.layout.welcome, null);
		setContentView(view);
		// 渐变展示启动屏
		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				redirectTo();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}

		});
	}

	private void deal_sth() {
		NetStateCheck nsc = new NetStateCheck(this.getApplicationContext());
		nsc.check_jwc();
		nsc.check_library();

		// 判断用户登录状态
		Yangtzeu.getHttpClient().get(Urls.jwc_cjcx_page,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						try {
							if (JwcRegex.is_not_login(response)) {
								 ComDB.kv_set("login_state", "false");
							} else {
								 ComDB.kv_set("login_state", "true");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					@Override
					public void onFailure(Throwable error, String content) {
						// TODO Auto-generated catch block
					}
				});
	}

	/**
	 * 跳转到Main页面
	 */
	private void redirectTo() {
		Intent intent = new Intent(this, Main.class);
		startActivity(intent);
		finish();
	}

	/**
	 * 按键事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
