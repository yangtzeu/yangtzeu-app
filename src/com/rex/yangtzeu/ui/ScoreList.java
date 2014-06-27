/**
 * 长大长新-长江大学校园安卓应用
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
import com.rex.yangtzeu.Yangtzeu;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ScoreList extends Activity {
	
	private ListView score_list_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_list);
		
		this.score_list_view = (ListView) findViewById(R.id.listview_score_list);
		
		if(Yangtzeu.sl_array != null){
			try{
				this.update_list();
			}catch(Exception e1){
				;
			}
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
	
	public void update_list(){
		List<Map<String, Object>> list_items = new ArrayList<Map<String, Object>>();
		int len = Yangtzeu.sl_array.length;
		
		if(len<=0){
			return;
		}
		
		for(int i=0; i<len; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			String[] items = Yangtzeu.sl_array[i].split(",");
			
			map.put("sl_subject_name", items[0]);
			map.put("sl_score", items[1]);
			map.put("sl_point", items[2]);
			map.put("sl_year", items[3]);
			map.put("sl_term", items[4]);
			map.put("sl_catalog", items[5]);
			list_items.add(map);
		}
		
		ListAdapter adapter = new SimpleAdapter(this, list_items,
				R.layout.score_list_item, new String[] { 
					"sl_subject_name", 
					"sl_score",
					"sl_point",
					"sl_year",
					"sl_term",
					"sl_catalog"
					},
				new int[] { 
						R.id.sl_subject_name,
						R.id.sl_score,
						R.id.sl_point,
						R.id.sl_year,
						R.id.sl_term,
						R.id.sl_catalog
					});
		this.score_list_view.setAdapter(adapter); 

	}
}
