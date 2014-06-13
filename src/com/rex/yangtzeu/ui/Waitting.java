package com.rex.yangtzeu.ui;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.rex.yangtzeu.R;

public class Waitting {
	/**
	 * 不能再onCreate中使用，因为要等到界面绘制完成才能调用
	 * @param act
	 * @param view
	 */
	public static PopupWindow waitting_pop_window(Activity act, View view) {
		PopupWindow pop_window;

		View layout = act.getLayoutInflater().inflate(R.layout.wait_popwin, null);
		pop_window = new PopupWindow(layout);
		pop_window.setWidth(100);
		pop_window.setHeight(100);
		
		pop_window.showAtLocation(view, Gravity.CENTER, 0, 50);
		
		return pop_window;
	}
}
