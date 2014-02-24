package com.rex.yuol;

import java.util.Map;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rex.yuol.config.Path;
import com.rex.yuol.regex.JwcReg;
import com.rex.yuol.utils.Sql;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
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

	/**
	 * 跳转到Main页面
	 */
	private void redirectTo() {

		// 测试
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://jwc.yangtzeu.edu.cn:8080/login.aspx",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						Map<String,String> rst=JwcReg.get_keys(response);
						if(Sql.kv_set("viewstate", rst.get("viewstate"))&&Sql.kv_set("eventvalidation", rst.get("eventvalidation"))){
							Toast.makeText(getApplicationContext(), "网络请求成功并成功存储到数据库", Toast.LENGTH_SHORT).show();
						}else{
							Toast.makeText(getApplicationContext(), "网络请求成功但存储到数据库失败", Toast.LENGTH_SHORT).show();
						};
					}
					@Override
					public void onFailure(Throwable error, String content){
						Toast.makeText(getApplicationContext(), "网络请求失败", Toast.LENGTH_SHORT).show();
						Log.i("welcome", "Failed to load welcome page!"+Sql.kv_get("test"));
					}
				});


//		Log.i("welcome", "loaded welcome page!");
		Path.save_file(Path.testfile, "李俊的测试");
		// 测试结束
		
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
