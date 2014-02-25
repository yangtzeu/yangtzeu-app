package com.rex.yuol.utils;

import java.util.Calendar;
import java.util.Date;

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

	public Timetable() {
		client_now.setToNow();
	}

	/**
	 * 时间戳
	 * @return
	 */
	public static long now() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 年
	 * @return
	 */
	public static int year() {
		Timetable tt=new Timetable();
		return tt.client_now.YEAR;
	}
	
	/**
	 * 月
	 * @return
	 */
	public static int month() {
		Timetable tt=new Timetable();
		return tt.client_now.MONTH;
	}
	
	/**
	 * 日
	 * @return
	 */
	public static int day() {
		Timetable tt=new Timetable();
		return tt.client_now.monthDay;
	}
	
	/**
	 * 星期
	 * @return
	 */
	public static int week() {
		Timetable tt=new Timetable();
		return tt.client_now.weekDay;
	}
	
	/**
	 * 时
	 * @return
	 */
	public static int hour() {
		Timetable tt=new Timetable();
		return tt.client_now.hour;
	}
	
	/**
	 * 分
	 * @return
	 */
	public static int minute() {
		Timetable tt=new Timetable();
		return tt.client_now.minute;
	}
	
	/**
	 * 秒
	 * @return
	 */
	public static int second() {
		Timetable tt=new Timetable();
		return tt.client_now.second;
	}

	public static void test() {
		Timetable tt = new Timetable();

	}
}
