package com.rex.yangtzeu.sqlite;

import android.database.Cursor;
import android.util.Log;

import com.rex.yangtzeu.Yangtzeu;

/**
 * 通用基本数据操作类，k-v存储
 * 
 * @author rex
 * 
 */
public class ComDB {
	/**
	 * 获取对应key的value
	 * 
	 * @param key
	 * @return 返回value
	 */
	public static String kv_get(String key) {
		Cursor cursor;
		String value = null;

		cursor = Yangtzeu.getDB().query("select * from kv where key='"+key+"'", null);
		if (cursor.moveToFirst()) {
			value = cursor.getString(cursor.getColumnIndex("value"));
		}
		cursor.close();
		return value;
	}

	/**
	 * kv表操作，设置对应key的value
	 * 
	 * @param key
	 * @param value
	 * @return 状态：false失败；true成功
	 */
	public static Boolean kv_set(String key, String value) {
		try {
			Yangtzeu.getDB().exec(
					"REPLACE INTO kv(key ,value) VALUES('" + key + "','"
							+ value + "')");
			return true;
		} catch (Exception e) {
			Log.e("rex", "插入失败");
			return false;
		}
	}
	
	
}
