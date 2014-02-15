package com.rex.yuol;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Jwc extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jwc_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jwc, menu);
		return true;
	}

}
