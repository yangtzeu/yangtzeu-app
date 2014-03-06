/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.utils;

import java.util.List;
import java.util.Map;
import android.content.Context;

public class Sql {

	public Sql(Context context) {
		;
	}

	/**
	 * 获取对应key的value
	 * 
	 * @param key
	 * @return 返回value
	 */
	public String kv_get(String key) {
		return null;
	}

	/**
	 * kv表操作，设置对应key的value
	 * 
	 * @param key
	 * @param value
	 * @return 状态：false失败；true成功
	 */
	public Boolean kv_set(String key, String value) {
		return false;
	}

	/**
	 * 保存更新院系表到数据库
	 * 
	 * @param list
	 * @return
	 */
	public boolean dep_update(String[] list) {
		return false;
	}

	/**
	 * 获取院系列表
	 * 
	 * @return
	 */
	public Map<String, List<String>> dep_list_get() {
		return null;
	}

}
