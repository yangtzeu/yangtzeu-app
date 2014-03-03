package com.rex.yangtzeu;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rex.yangtzeu.config.Path;
import com.rex.yangtzeu.config.Urls;
import com.rex.yangtzeu.http.Net;
import com.rex.yangtzeu.http.NetStateCheck;
import com.rex.yangtzeu.regex.JwcRegex;
import com.rex.yangtzeu.utils.Sql;
import com.rex.yangtzeu.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

		new Thread(new Runnable() {
			public void run() {
				deal_sth();
			}
		}).start();

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

	private void deal_sth() {
		// 测试
		NetStateCheck nsc = new NetStateCheck(this.getApplicationContext());
		nsc.check_jwc();
		nsc.check_library();

		Net.create_async_http(getApplicationContext()).get(
				"http://jwc.yangtzeu.edu.cn:8080/student.aspx",
				new AsyncHttpResponseHandler() {
					@Override
					public void onStart() {
						setCharset("GB2312");
					}

					@Override
					public void onSuccess(String response) {
						String[] split_array = JwcRegex
								.parse_department_list(response);
						Sql.dep_update(split_array);
					}
				});

		// 判断用户登录状态
		Net.create_async_http(getApplicationContext()).get(Urls.jwc_cjcx_page,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						try {
							if (JwcRegex.is_not_login(response)) {
								Sql.kv_set("login_state", "false");
							} else {
								Sql.kv_set("login_state", "true");
							}
							;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void onFailure(Throwable error, String content) {
						// TODO Auto-generated catch block
					}
				});
		Path.save_file(Path.testfile, "李俊的测试");
		// 测试结束
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

}
