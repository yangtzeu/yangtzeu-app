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

import com.rex.yangtzeu.R;
import com.rex.yangtzeu.config.Urls;
import com.rex.yangtzeu.http.YuHttp;
import com.rex.yangtzeu.regex.JwcRegex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class Jwc extends Activity implements android.view.View.OnClickListener {
	private LinearLayout btn1;
	private LinearLayout btn2;
	private LinearLayout btn3;
	private LinearLayout btn4;
	private LinearLayout btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jwc);
		
		btn1 = (LinearLayout) this.findViewById(R.id.jwc_chafen);
		btn2 = (LinearLayout) this.findViewById(R.id.find_stu);
		btn3 = (LinearLayout) this.findViewById(R.id.ch_cls);
		btn4 = (LinearLayout) this.findViewById(R.id.kebiao_btn);
		btn5 = (LinearLayout) this.findViewById(R.id.cet_btn);
		
		btn1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 抬起时白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 抬起时白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 抬起时白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 抬起时白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn5.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 抬起时白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
	}


	/**
	 * 按键事件
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 后退动画
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			overridePendingTransition(R.anim.back_left_in,
					R.anim.back_right_out);

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0 == btn1) {
			// 查分
			new NetTask().execute("load_page");
		}
	}
	
	public void redirect_to(String tag){
		if(tag == "jwc"){
			Intent intent = new Intent(this, JwcChafen.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
		}
	}

	// Async load_cfpage_task TODO
	private class NetTask extends AsyncTask<String, Void,String> {
		String optype;

		protected void onPostExecute(String result) {
			if(this.optype == "load_page"){ // 载入页面
				redirect_to("jwc");
			}
		}
		
		@Override
		protected String doInBackground(String... arg0) {
			this.optype = arg0[0];
			if(arg0[0] == "load_page"){ // 载入页面
				String result = "";
				try {
					result = YuHttp.get(Urls.jwc_cjcx_page, "gb2312");
					JwcRegex.get_viewstate_keys(result);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}
}
