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
import com.rex.yangtzeu.utils.Timetable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity implements android.view.View.OnClickListener {
	private LinearLayout btn1;
	private LinearLayout btn2;
	private LinearLayout btn3;
	private LinearLayout btn4;
	private LinearLayout btn5;
	private TextView tip_main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn1 = (LinearLayout) this.findViewById(R.id.jwc_btn);
		btn2 = (LinearLayout) this.findViewById(R.id.library_btn);
		btn3 = (LinearLayout) this.findViewById(R.id.notice_btn);
		btn4 = (LinearLayout) this.findViewById(R.id.news_btn);
		btn5 = (LinearLayout) this.findViewById(R.id.setting_btn);
		
		tip_main = (TextView) this.findViewById(R.id.tips_main);
        String[] week = {"日","一","二","三","四","五","六"};
		String tip = "今天是"+Timetable.month()+"月"+Timetable.day()+"日\n第1周 星期"+ week[Timetable.week()];
		tip_main.setText(tip);

		btn1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时的背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时的背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时的背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时的背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的白色
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
				return false;
			}
		});
		btn5.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 按下时的背景透明
					v.setBackgroundColor(Color.parseColor("#00000000"));
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的白色
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

	/*
	 * 按后退键则关闭程序
	 * 
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			System.exit(0);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View arg0) {
		if (arg0 == btn1) {
			// jwc
			Intent intent = new Intent(this, Jwc.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		} else if (arg0 == btn2) {
			// library
			Intent intent = new Intent(this, Library.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		} else if (arg0 == btn3) {
			// notice
			Intent intent = new Intent(this, Notice.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		} else if (arg0 == btn4) {
			// news
			Intent intent = new Intent(this, News.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		} else if (arg0 == btn5) {
			// setting
			Intent intent = new Intent(this, Setting.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		}
	}

	 
}
