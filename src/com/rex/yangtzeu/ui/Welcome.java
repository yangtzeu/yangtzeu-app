/**
 * 长大长新-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.ui;

import com.rex.yangtzeu.R;
import com.rex.yangtzeu.Yangtzeu;
import com.rex.yangtzeu.http.JwcWeb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
	private void redirect_to() {
		Intent intent = new Intent(this, Main.class);
		startActivity(intent);
		finish();
	}

	// Async Login
	private class LoginTask extends AsyncTask<String, Void,String> {
		boolean login_result = false; 
		
		protected void onPostExecute(String result) {
			if(this.login_result){
				Toast.makeText(Yangtzeu.getInstance(), "登录成功", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(Yangtzeu.getInstance(), "登录失败", Toast.LENGTH_LONG).show();
			}
			redirect_to();
		}
		
		@Override
		protected String doInBackground(String... arg0) {
			this.login_result = JwcWeb.jwc_login();
			return null;
		}
	}

}
