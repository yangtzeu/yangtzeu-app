package com.rex.yuol;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class Jwc extends Activity implements android.view.View.OnClickListener {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jwc);
		
		btn1 = (Button) this.findViewById(R.id.jwc_chafen);
		btn2 = (Button) this.findViewById(R.id.find_stu);
		btn3 = (Button) this.findViewById(R.id.ch_cls);
		btn4 = (Button) this.findViewById(R.id.kebiao_btn);
		btn5 = (Button) this.findViewById(R.id.cet_btn);
		
		btn1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.main_jwc);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.main_jwc);
				}
				return false;
			}
		});
		btn2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.main_library);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.main_library);
				}
				return false;
			}
		});
		btn3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_notice_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_notice);
				}
				return false;
			}
		});
		btn4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_news_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_news);
				}
				return false;
			}
		});
		btn5.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_setting_p);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
//					v.setBackgroundResource(R.drawable.yuol_main_tile_setting);
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
			Intent intent = new Intent(this, JwcChafen.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);

		}
	}

}
