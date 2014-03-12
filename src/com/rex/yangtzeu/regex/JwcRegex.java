/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.rex.yangtzeu.Yangtzeu;

public class JwcRegex {
	/**
	 * 获取登录页上的VIEWSTATE吗，供登录使用
	 * 
	 * @param content
	 *            原网页
	 * @return map<s,s>结构的参数表
	 * @throws Exception
	 *             正则匹配失败
	 */
	public static boolean get_viewstate_keys(String content) {
//		Log.i("rex","content:"+content);
		String key1 = "", key2 = "";
		String regEx1 = "__VIEWSTATE\" value=\"([/d/D][^\"]+)\"";
		String regEx2 = "__EVENTVALIDATION\" value=\"([/d/D][^\"]+)\"";

		Pattern pat1 = Pattern.compile(regEx1);
		Matcher mat1 = pat1.matcher(content);
		boolean rs1 = mat1.find();
		// 如果没有匹配到
		if (!rs1) {
			return false;
		}
		key1 = mat1.group(1);
		Yangtzeu.jwc_login_viewstate = key1;
		
		Pattern pat2 = Pattern.compile(regEx2);
		Matcher mat2 = pat2.matcher(content);
		boolean rs2 = mat2.find();
		if (!rs2) {
			return false;
		}
		key2 = mat2.group(1);
		Yangtzeu.jwc_login_eventvalidation = key2;
		return true;
	}

	/**
	 * 判断未登录
	 * 
	 * @param content
	 *            内容
	 * @return true未登录
	 * @throws Exception
	 *             空内容
	 */
	public static boolean is_not_login(String content){
		if (content.equals("")) {
			return true;
		}
		String regEx1 = "^<script>alert";
		Pattern pat1 = Pattern.compile(regEx1);
		Matcher mat1 = pat1.matcher(content);
		Boolean result = mat1.find();
		return result;
	}

	/**
	 * 解析院系列表
	 * 
	 * @return
	 */
	public static String[] parse_department_list(String content) {
		String pdl_pregex = "<option selected=\\\"selected\\\"([\\d\\D][^:]+)</select>";
		Pattern pat1 = Pattern.compile(pdl_pregex);
		Matcher mat1 = pat1.matcher(content);
		if (mat1.find()) {
			String raw = mat1.group(1).replace("<option", "")
					.replace("</option>", "").replace("value=", "")
					.replace(">", ",").replace("\"", "").replace("\t", "")
					.replace("\r", "");

			return raw.split("\n");
		}
		return null;
	}

}
