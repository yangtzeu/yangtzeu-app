package com.rex.yuol;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.ColorMatrixColorFilter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements android.view.View.OnClickListener {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn1 = (Button) this.findViewById(R.id.jwc_btn);
		btn2 = (Button) this.findViewById(R.id.library_btn);
		btn3 = (Button) this.findViewById(R.id.notice_btn);
		btn4 = (Button) this.findViewById(R.id.news_btn);
		btn5 = (Button) this.findViewById(R.id.setting_btn);
		
		btn1.setOnTouchListener(new OnTouchListener(){     
	        public boolean onTouch(View v, MotionEvent event) {
	                if(event.getAction() == MotionEvent.ACTION_DOWN){     
	                        //更改为按下时的背景图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_jwc_p);     
	                }else if(event.getAction() == MotionEvent.ACTION_UP){     
	                        //改为抬起时的图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_jwc);     
	                }  
	                return false;     
	        }
		}); 
		btn2.setOnTouchListener(new OnTouchListener(){     
	        public boolean onTouch(View v, MotionEvent event) {
	                if(event.getAction() == MotionEvent.ACTION_DOWN){     
	                        //更改为按下时的背景图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_library_p);     
	                }else if(event.getAction() == MotionEvent.ACTION_UP){     
	                        //改为抬起时的图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_library);     
	                }  
	                return false;     
	        }
		}); 
		btn3.setOnTouchListener(new OnTouchListener(){     
	        public boolean onTouch(View v, MotionEvent event) {
	                if(event.getAction() == MotionEvent.ACTION_DOWN){     
	                        //更改为按下时的背景图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_notice_p);     
	                }else if(event.getAction() == MotionEvent.ACTION_UP){     
	                        //改为抬起时的图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_notice);     
	                }  
	                return false;     
	        }
		}); 
		btn4.setOnTouchListener(new OnTouchListener(){     
	        public boolean onTouch(View v, MotionEvent event) {
	                if(event.getAction() == MotionEvent.ACTION_DOWN){     
	                        //更改为按下时的背景图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_news_p);     
	                }else if(event.getAction() == MotionEvent.ACTION_UP){     
	                        //改为抬起时的图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_news);     
	                }  
	                return false;     
	        }
		}); 
		btn5.setOnTouchListener(new OnTouchListener(){     
	        public boolean onTouch(View v, MotionEvent event) {
	                if(event.getAction() == MotionEvent.ACTION_DOWN){     
	                        //更改为按下时的背景图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_setting_p);     
	                }else if(event.getAction() == MotionEvent.ACTION_UP){     
	                        //改为抬起时的图片     
	                        v.setBackgroundResource(R.drawable.yuol_main_tile_setting);     
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
		if(arg0==btn1){
			
			Toast.makeText(getApplicationContext(), R.string.jwc,
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, Jwc.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//			finish();
			
		}else if(arg0==btn2){
			Toast.makeText(getApplicationContext(), R.string.library,
					Toast.LENGTH_SHORT).show();
		}else if(arg0==btn3){
			Toast.makeText(getApplicationContext(), R.string.notice,
					Toast.LENGTH_SHORT).show();
		}else if(arg0==btn4){
			Toast.makeText(getApplicationContext(), R.string.news,
					Toast.LENGTH_SHORT).show();
		}else if(arg0==btn5){
			Toast.makeText(getApplicationContext(), R.string.setting,
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, Setting.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			
		}
		// TODO Auto-generated method stub
//		AsyncHttpClient client = new AsyncHttpClient();
//		client.get("http://wap.baidu.com", new AsyncHttpResponseHandler() {
//			@Override
//			public void onSuccess(String response) {
//				Toast.makeText(getApplicationContext(), response,
//						Toast.LENGTH_SHORT).show();
//				;
//			}
//		});
	}

	/**
	 * 按钮触发样式
	 */
	
}
