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

import android.text.format.Time;
import android.util.Log;

/**
 * 作息时间表计算
 * 
 * @author rex
 * 
 */
public class Timetable {
	Time client_now = new Time();
	private static int[] time_table = {
			// Morning
			73000, 80000, 93500, 100500, 114000,
			// Noon
			140000, 153500, 160500, 174000,
			// Night
			190000, 203500, 235900 };

	private static String[] timetable_tips = new String[] {
			// Morning
			"早上好", "8:00上第一节课", "9:35下第一节课", "10:05上第二节课", "11:40下第二节课",
			// Noon
			"14:00上第三节课", "15:35下第三节课", "16:05上第四节课", "17:40下第四节课",
			// Night
			"19:00上晚自习", "20:35下晚自习",
			//
			"晚安"

	};

	public Timetable() {
		client_now.setToNow();
	}

	/**
	 * 时间戳
	 * 
	 * @return
	 */
	public static long timestamp() {
		return System.currentTimeMillis();
	}

	/**
	 * 年
	 * 
	 * @return
	 */
	public static int year() {
		Timetable tt = new Timetable();
		return tt.client_now.YEAR;
	}

	/**
	 * 月
	 * 
	 * @return
	 */
	public static int month() {
		Timetable tt = new Timetable();
		return tt.client_now.MONTH;
	}

	/**
	 * 日
	 * 
	 * @return
	 */
	public static int day() {
		Timetable tt = new Timetable();
		return tt.client_now.monthDay;
	}

	/**
	 * 星期
	 * 
	 * @return
	 */
	public static int week() {
		Timetable tt = new Timetable();
		return tt.client_now.weekDay;
	}

	/**
	 * 时[24小时制]
	 * 
	 * @return
	 */
	public static int hour() {
		Timetable tt = new Timetable();
		return tt.client_now.hour;
	}

	/**
	 * 分
	 * 
	 * @return
	 */
	public static int minute() {
		Timetable tt = new Timetable();
		return tt.client_now.minute;
	}

	/**
	 * 秒
	 * 
	 * @return
	 */
	public static int second() {
		Timetable tt = new Timetable();
		return tt.client_now.second;
	}

	/**
	 * 当前上课状态
	 * 
	 * @return
	 */
	public static String now_state() {
		String tip = "";
		int now = Timetable.hour() * 10000 + Timetable.minute() * 100
				+ Timetable.second();
		for (int i = 0; i < time_table.length; ++i) {
			if (time_table[i] > now) {
				tip = timetable_tips[i];
				break;
			}
		}
		return tip;
	}

	public static void test() {
		// Timetable tt = new Timetable();
		Log.i("welcome", "hour:" + Timetable.hour());
	}
}
