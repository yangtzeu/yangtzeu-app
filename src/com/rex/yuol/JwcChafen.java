/**
 * 掌上长大-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yuol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class JwcChafen extends Activity implements
		android.view.View.OnClickListener {
	private LinearLayout drop_list1;
	private LinearLayout drop_list2;
	private LinearLayout btn1;
	private LinearLayout btn2;
	private LinearLayout btn3;
	private LinearLayout btn4;

	private PopupWindow pwMyPopWindow;// popupwindow
	private ListView lvPopupList;// popupwindow中的ListView
	List<Map<String, String>> moreList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jwc_chafen);

		drop_list1 = (LinearLayout) this.findViewById(R.id.drop_list1);
		drop_list2 = (LinearLayout) this.findViewById(R.id.drop_list2);
		btn1 = (LinearLayout) this.findViewById(R.id.button1);
		btn2 = (LinearLayout) this.findViewById(R.id.button2);
		btn3 = (LinearLayout) this.findViewById(R.id.button3);
		btn4 = (LinearLayout) this.findViewById(R.id.button4);

		drop_list1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_b_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_b);
				}
				return false;
			}
		});
		drop_list2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_b_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_b);
				}
				return false;
			}
		});
		btn1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y);
				}
				return false;
			}
		});
		btn2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y);
				}
				return false;
			}
		});
		btn3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y);
				}
				return false;
			}
		});
		btn4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.jwc_chafen_btn_y);
				}
				return false;
			}
		});

		drop_list1.setOnClickListener(this);
		drop_list2.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
	}

	private void iniPopupWindow() {

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.dialog_drop_list, null);
		lvPopupList = (ListView) layout.findViewById(R.id.drop_list);
		List<Map<String, Object>> list_items = new ArrayList<Map<String, Object>>();
//		TODO 创建一个院系数组
		SimpleAdapter adapter = new SimpleAdapter(this, list_items,
				R.layout.drop_list_item, new String[] { "item_title", "tick" },
				new int[] { R.id.drop_list_item_title,
						R.id.drop_list_item_check });
		lvPopupList.setAdapter(adapter);
		pwMyPopWindow = new PopupWindow(layout);
		pwMyPopWindow.setFocusable(true);// 加上这个popupwindow中的ListView才可以接收点击事件

		// 控制popupwindow的宽度和高度自适应
		lvPopupList.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);
		pwMyPopWindow.setWidth(drop_list1.getMeasuredWidth());
		pwMyPopWindow.setHeight((lvPopupList.getMeasuredHeight()) * 3);

		// 控制popupwindow点击屏幕其他地方消失
		pwMyPopWindow.setBackgroundDrawable(this.getResources().getDrawable(
				R.drawable.jwc_chafen_btn_b));// 设置背景图片，不能在布局中设置，要通过代码来设置
		pwMyPopWindow.setOutsideTouchable(true);// 触摸popupwindow外部，popupwindow消失。这个要求你的popupwindow要有背景图片才可以成功，如上
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0 == drop_list1) {
			iniPopupWindow();
			pwMyPopWindow.showAsDropDown(drop_list1);
			Toast.makeText(getApplicationContext(), "droplist",
					Toast.LENGTH_SHORT).show();
		}
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

}
