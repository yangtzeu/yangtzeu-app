package com.rex.yuol;

import java.util.Timer;
import java.util.TimerTask;

import com.rex.yuol.utils.HttpUtils;

import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		TimerTask task = new TimerTask() {
			public void run() {
				
				Intent intent = new Intent();
				intent.setClass(Welcome.this, Main.class);
				startActivity(intent);
				finish();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
