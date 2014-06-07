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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.rex.yangtzeu.R;
import com.rex.yangtzeu.utils.Timetable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class JwcChafen extends Activity implements
		android.view.View.OnClickListener {
	private LinearLayout drop_list1;
	private LinearLayout drop_list2;
	private LinearLayout btn1;
	private LinearLayout btn2;
	private LinearLayout btn3;
	private LinearLayout btn4;
	private TextView set_cf_year;
	private TextView set_cf_term;

	private PopupWindow year_pop_win_droplist;// 年份 pop window
	private ListView year_popup_list;// 年份pop window中的ListView
	
	private PopupWindow term_pop_win_droplist;// 学期 pop window
	private ListView term_popup_list;// 学期pop window中的ListView

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
		
		// 初始化年份为当前年
		set_cf_year = (TextView)findViewById(R.id.cf_year);
		set_cf_year.setText(Timetable.year()+""); 
		
		// 初始化当前学期(2~8下学期，9~1下学期)
		set_cf_term = (TextView)findViewById(R.id.cf_term);
		if(Timetable.term()){
			set_cf_term.setText("上学期");
		}else{
			set_cf_term.setText("下学期");
		}

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

	/**
	 * 年份下拉列表
	 * 
	 * @return
	 */
	private PopupWindow year_drop_list_win() {
		final PopupWindow pop_window;

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.dialog_drop_list, null);
		year_popup_list = (ListView) layout.findViewById(R.id.drop_list);

		List<Map<String, Object>> list_items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 7; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("item_title", (Timetable.year() - 3 + i)+"");
			
			map.put("tick", "");
			list_items.add(map);
		}
		// 设置列表条目样式
		SimpleAdapter adapter = new SimpleAdapter(this, list_items,
				R.layout.drop_list_item, new String[] { "item_title", "tick" },
				new int[] { R.id.drop_list_item_title,
						R.id.drop_list_item_check });
		// 绑定列表
		year_popup_list.setAdapter(adapter);
		pop_window = new PopupWindow(layout);
		pop_window.setFocusable(true);

		// 控制下拉列表的宽度和高度自适应
		year_popup_list.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);
		pop_window.setWidth(drop_list1.getMeasuredWidth());
		pop_window.setHeight((year_popup_list.getMeasuredHeight()) * 6);

		// 控制点击下拉列表之外的地方消失
		pop_window.setBackgroundDrawable(this.getResources().getDrawable(
				R.drawable.jwc_chafen_btn_b));
		pop_window.setOutsideTouchable(true);
		
		// 列表点击事件
		year_popup_list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int item_index,
					long arg3) {
				// 将年份填入set_cf_year
				set_cf_year.setText((Timetable.year() - 3 + item_index)+"");
				// 关闭下拉列表
				pop_window.dismiss();
			}});

		return pop_window;
	}
	
	
	/**
	 * 学期下拉列表
	 * 
	 * @return
	 */
	private PopupWindow term_drop_list_win() {
		final PopupWindow pop_window;

		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.dialog_drop_list, null);
		term_popup_list = (ListView) layout.findViewById(R.id.drop_list);

		// 列表内容
		List<Map<String, Object>> list_items = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("item_title", "上学期");
		map1.put("tick", "");
		list_items.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("item_title", "下学期");
		map2.put("tick", "");
		list_items.add(map2);
			
		// 设置列表条目样式
		SimpleAdapter adapter = new SimpleAdapter(this, list_items,
				R.layout.drop_list_item, new String[] { "item_title", "tick" },
				new int[] { R.id.drop_list_item_title,
						R.id.drop_list_item_check });
		// 绑定列表
		term_popup_list.setAdapter(adapter);
		pop_window = new PopupWindow(layout);
		pop_window.setFocusable(true);

		// 控制下拉列表的宽度和高度自适应
		term_popup_list.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);
		pop_window.setWidth(drop_list2.getMeasuredWidth());
		pop_window.setHeight((term_popup_list.getMeasuredHeight() + 7) * 2);

		// 控制点击下拉列表之外的地方消失
		pop_window.setBackgroundDrawable(this.getResources().getDrawable(
				R.drawable.jwc_chafen_btn_b));
		pop_window.setOutsideTouchable(true);
		
		// 列表点击事件
		term_popup_list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int item_index,
					long arg3) {
				// 将年份填入set_cf_term
				if(item_index == 0){
					set_cf_term.setText("上学期");
				}else{
					set_cf_term.setText("下学期");
				}
				
				// 关闭下拉列表
				pop_window.dismiss();
			}});

		return pop_window;
	}
	

	// 点击打开下拉列表
	@Override
	public void onClick(View view) { // TODO
		if (view == drop_list1) {
			year_pop_win_droplist = year_drop_list_win();
			year_pop_win_droplist.showAsDropDown(drop_list1);
		}else if(view == drop_list2){
			term_pop_win_droplist = term_drop_list_win();
			term_pop_win_droplist.showAsDropDown(drop_list2);
		}else if(view == btn1){ // 按钮“本学期成绩”
			redirect_to();
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
	
	/**
	 * 获取当前选择的年份
	 * @return
	 */
	private String get_year(){
		return set_cf_year.getText().toString();
	}
	
	/**
	 * 获取当前学期
	 * @return 1：上学期，2：下学期  
	 */
	private int get_term(){
		if(set_cf_year.getText().toString()=="下学期"){
			return 2; // 下学期
		}else{
			return 1; // 上学期
		}
	}
	
	/**
	 * 跳转到成绩列表页
	 */
	private void redirect_to(){
		Intent intent = new Intent(this, ScoreList.class);
		startActivity(intent);
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
	}
	

}
