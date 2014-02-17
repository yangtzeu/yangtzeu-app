package com.rex.yuol;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;

public class Setting extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
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
