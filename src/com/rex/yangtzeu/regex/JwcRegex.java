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

import java.io.UnsupportedEncodingException;
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
	 * @throws Exception
	 *             正则匹配失败
	 */
	public static Map<String, String> get_keys(String content) {
		Map<String, String> map = new HashMap<String, String>();
		String key1 = "", key2 = "";
		String regEx1 = "__VIEWSTATE\" value=\"([/d/D][^\"]+)\"";
		String regEx2 = "__EVENTVALIDATION\" value=\"([/d/D][^\"]+)\"";

		Pattern pat1 = Pattern.compile(regEx1);
		Matcher mat1 = pat1.matcher(content);
		boolean rs1 = mat1.find();
		// 如果没有匹配到
		if (!rs1) {
			Log.i("rex","正则匹配失败!没找到__VIEWSTATE,__EVENTVALIDATION...");
		}
		key1 = mat1.group(1);
		map.put("viewstate", key1);

		Pattern pat2 = Pattern.compile(regEx2);
		Matcher mat2 = pat2.matcher(content);
		key2 = mat2.group(1);
		map.put("eventvalidation", key2);

		Log.i("regex", key1 + "==>" + key2);
		return map;
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
	public static boolean is_not_login(String content) throws Exception {
		if (content.equals("")) {
			throw new Exception("内容为空！");
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

	public static String gbToUtf8(String str)
			throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, i + 1);
			if (s.charAt(0) > 0x80) {
				byte[] bytes = s.getBytes("Unicode");
				String binaryStr = "";
				for (int j = 2; j < bytes.length; j += 2) {
					// the first byte
					String hexStr = getHexString(bytes[j + 1]);
					String binStr = getBinaryString(Integer.valueOf(hexStr, 16));
					binaryStr += binStr;
					// the second byte
					hexStr = getHexString(bytes[j]);
					binStr = getBinaryString(Integer.valueOf(hexStr, 16));
					binaryStr += binStr;
				}
				// convert unicode to utf-8
				String s1 = "1110" + binaryStr.substring(0, 4);
				String s2 = "10" + binaryStr.substring(4, 10);
				String s3 = "10" + binaryStr.substring(10, 16);
				byte[] bs = new byte[3];
				bs[0] = Integer.valueOf(s1, 2).byteValue();
				bs[1] = Integer.valueOf(s2, 2).byteValue();
				bs[2] = Integer.valueOf(s3, 2).byteValue();
				String ss = new String(bs, "UTF-8");
				sb.append(ss);
			} else {
				sb.append(s);
			}
		}
		return sb.toString();
	}

	private static String getHexString(byte b) {
		String hexStr = Integer.toHexString(b);
		int m = hexStr.length();
		if (m < 2) {
			hexStr = "0" + hexStr;
		} else {
			hexStr = hexStr.substring(m - 2);
		}
		return hexStr;
	}

	private static String getBinaryString(int i) {
		String binaryStr = Integer.toBinaryString(i);
		int length = binaryStr.length();
		for (int l = 0; l < 8 - length; l++) {
			binaryStr = "0" + binaryStr;
		}
		return binaryStr;
	}
}
