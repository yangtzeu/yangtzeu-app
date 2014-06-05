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

import com.rex.yangtzeu.http.JwcHttp;
import com.rex.yangtzeu.R;
import com.rex.yangtzeu.Yangtzeu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
		
		final View view = View.inflate(this, R.layout.welcome, null);
		setContentView(view);
		
		// 渐变展示启动屏
		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				// Start Login
				new LoginTask().execute();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}

		});
		
		view.startAnimation(aa);

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
	
	// Async Login
	private class LoginTask extends AsyncTask<String, Void,Bitmap> {
		boolean login_result = false; 
		
		protected void onPostExecute(Bitmap result) {
			if(this.login_result){
				Toast.makeText(Yangtzeu.getInstance(), "登陸成功", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(Yangtzeu.getInstance(), "登陸失敗", Toast.LENGTH_LONG).show();
			}
			redirectTo();
		}
		
		@Override
		protected Bitmap doInBackground(String... arg0) {
			this.login_result = JwcHttp.jwc_login();
			return null;
		}
	}

}
