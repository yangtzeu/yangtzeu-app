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

import com.rex.yuol.utils.EncrypAES;
import com.rex.yuol.utils.Sql;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setting extends Activity implements
		android.view.View.OnClickListener {
	private Button btn_save;
	private EditText stu_no;
	private EditText stu_mm;
	private EditText jsz_no;
	private EditText jsz_mm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);

		btn_save = (Button) this.findViewById(R.id.save_btn);

		btn_save.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.yuol_main_title);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.yuol_title_btn_bg);
				}
				return false;
			}
		});

		btn_save.setOnClickListener(this);

		// 数据填充到表单
		stu_no = (EditText) findViewById(R.id.student_no);
		stu_no.setText(Sql.kv_get("student_number"));

		stu_mm = (EditText) findViewById(R.id.jwc_mima);
		stu_mm.setText(EncrypAES.decrypt(Sql.kv_get("student_password")));

		jsz_no = (EditText) findViewById(R.id.jsz_no);
		jsz_no.setText(Sql.kv_get("library_number"));

		jsz_mm = (EditText) findViewById(R.id.jsz_mima);
		jsz_mm.setText(EncrypAES.decrypt(Sql.kv_get("library_password")));
	}

	@Override
	public void onClick(View arg0) {
		if (arg0 == btn_save) {
			// 保存表单信息
			String text_stu_no = stu_no.getText().toString();
			String text_stu_mm = stu_mm.getText().toString();
			String text_jsz_no = jsz_no.getText().toString();
			String text_jsz_mm = jsz_mm.getText().toString();

			if (!text_stu_no.equals("") && !text_stu_mm.equals("")) {
				Sql.kv_set("student_number", text_stu_no);
				Sql.kv_set("student_password", EncrypAES.encrypt(text_stu_mm));
			}
			if (!text_jsz_no.equals("") && !text_jsz_mm.equals("")) {
				Sql.kv_set("library_number", text_jsz_no);
				Sql.kv_set("library_password", EncrypAES.encrypt(text_jsz_mm));
			}
			Toast.makeText(getApplicationContext(), "已保存", Toast.LENGTH_SHORT)
					.show();
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
