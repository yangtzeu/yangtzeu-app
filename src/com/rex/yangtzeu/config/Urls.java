/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.config;

public class Urls {

	// 教务处
	public static String jwc_home = "http://jwc.yangtzeu.edu.cn:8080/";
	public static String jwc_login_page = jwc_home + "login.aspx";
	public static String jwc_login_response = jwc_home + "login.aspx";
	public static String jwc_cjcx_page = jwc_home + "cjcx.aspx";
	public static String jwc_search_student_page = jwc_home + "student.aspx";
	public static String jwc_search_student_response = jwc_home
			+ "student.aspx";
	public static String jwc_search_class_student_page = jwc_home
			+ "student.aspx";
	public static String jwc_search_class_student_response = jwc_home
			+ "student.aspx";

	// 长大首页
	public static String yz_home = "http://www.yangtzeu.edu.cn/";
	public static String yz_news_home = "http://news.yangtzeu.edu.cn/";

	// 长大在线
	public static String yuol_home = "http://online.yangtzeu.edu.cn/";

	// cet 查分API格式如下
	// http://www.chsi.com.cn/cet/query?zkzh=420611122213619&xm=李俊
	public static String cet_score = "http://www.chsi.com.cn/cet/query";

}
