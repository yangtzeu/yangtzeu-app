package com.rex.yuol.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

public class JwcRegex {
	/**
	 * 获取登录页上的VIEWSTATE吗，供登录使用
	 * 
	 * @param content
	 *            原网页
	 * @return map<s,s>结构的参数表
	 */
	public static Map<String, String> get_keys(String content) {
		Map<String, String> map = new HashMap<String, String>();
		String key1 = "", key2 = "";
		String regEx1 = "__VIEWSTATE\" value=\"([/d/D][^\"]+)\"";
		String regEx2 = "__EVENTVALIDATION\" value=\"([/d/D][^\"]+)\"";

		Pattern pat1 = Pattern.compile(regEx1);
		Matcher mat1 = pat1.matcher(content);
		boolean rs1 = mat1.find();
		key1 = mat1.group(1);
		map.put("viewstate", key1);

		Pattern pat2 = Pattern.compile(regEx2);
		Matcher mat2 = pat2.matcher(content);
		boolean rs2 = mat2.find();
		key2 = mat2.group(1);
		map.put("eventvalidation", key2);

		Log.i("regex", key1 + "==>" + key2);
		return map;
	}
}
