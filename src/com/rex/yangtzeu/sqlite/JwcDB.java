package com.rex.yangtzeu.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.database.Cursor;

import com.rex.yangtzeu.Yangtzeu;

/**
 * 教務處數據存儲類
 * 
 * @author rex
 * 
 */
public class JwcDB {

	/**
	 * 保存更新院系表到数据库
	 * 
	 * @param list
	 * @return
	 */
	public static boolean dep_update(String[] list) {
		if (!list.equals(null)) {
			for (int i = 0; i < list.length; i++) {
				String[] item = list[i].split(",");

				int dep_id = Integer.parseInt(item[0].trim());
				try {
					Yangtzeu.getDB().exec(
							"REPLACE INTO departments(dep_id,dep_name,dep_rate,dep_note) VALUES('"
									+ dep_id + "','" + item[1].trim()
									+ "','0','')");
				} catch (Exception e) {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * 获取院系列表
	 * 
	 * @return
	 */
	public static Map<String, List<String>> dep_list_get() {
		Cursor cursor;
		
		List<String> result_id = new ArrayList<String>();
		List<String> result_name = new ArrayList<String>();
		
		cursor = Yangtzeu.getDB().query(
				"select * from departments order by dep_rate desc", null);
		while (cursor.moveToNext()) {
			result_id.add(cursor.getInt(cursor.getColumnIndex("dep_id")) + "");
			result_name
					.add(cursor.getString(cursor.getColumnIndex("dep_name")));
		}

		cursor.close();

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("id", result_id);
		map.put("name", result_name);

		return map;
	}
}
