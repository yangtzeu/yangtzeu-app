/**
 * 掌上长大-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.utils;

import java.util.Map;

import com.rex.yangtzeu.config.Path;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;
import android.widget.Toast;

public class Sql {
	private SQLiteDatabase db;

	public Sql() {
		// 打开或创建test.db数据库
		db = SQLiteDatabase.openOrCreateDatabase(Path.check_dir() + "/yuol.db",
				null);
		this.db_init();
	}

	/**
	 * 打开并创建数据表
	 * 
	 * @return 数据库
	 */
	public SQLiteDatabase db_init() {
		// 创建kv表
		create_table(
				"kv",
				"CREATE TABLE [kv] ([key] VARCHAR(20) UNIQUE NOT NULL PRIMARY KEY,[value] TEXT NOT NULL)");
		// 创建jwc_notice_list表
		create_table(
				"jwc_notice_list",
				"CREATE TABLE [jwc_notice_list] ([url] NVARCHAR(512) UNIQUE NOT NULL PRIMARY KEY,[time] DATE NOT NULL, [title] NVARCHAR(512) NOT NULL )");
		// 创建jwc_news_list表
		create_table(
				"jwc_news_list",
				"CREATE TABLE [jwc_news_list] ([url] NVARCHAR(512) UNIQUE NOT NULL PRIMARY KEY, [time] DATE NOT NULL,[title] NVARCHAR(512) NOT NULL)");
		// 创建departments表
		create_table(
				"departments",
				"CREATE TABLE [departments] ([dep_id] INTEGER  UNIQUE NOT NULL,[dep_name] VARCHAR(30)  NOT NULL,[dep_rate] INTEGER DEFAULT '0' NOT NULL,[dep_note] VARCHAR(30)  NULL)");
		// 创建classes表
		create_table(
				"classes",
				"CREATE TABLE [classes] ([cls_id] INTEGER  NOT NULL PRIMARY KEY,[cls_name] VARCHAR(30)  NOT NULL,[cls_dep] INTEGER  NOT NULL,[cls_rate] INTEGER DEFAULT '0' NOT NULL,[cls_note] VARCHAR(30)  NULL)");

		return db;
	}

	/**
	 * 创建表
	 * 
	 * @param table_name
	 * @param create_table_sql
	 */
	private void create_table(String table_name, String create_table_sql) {
		String check_exist_table = "SELECT count(*) as c FROM sqlite_master WHERE type='table' AND name='"
				+ table_name + "'";
		Cursor cursor = db.rawQuery(check_exist_table, null);
		int count = 0;
		if (cursor.moveToFirst()) {
			count = cursor.getInt(cursor.getColumnIndex("c"));
		}
		if (count == 0) {
			// 创建表
			db.execSQL(create_table_sql);
		}
	}

	/**
	 * 获取对应key的value
	 * 
	 * @param key
	 * @return 返回value
	 */
	static public String kv_get(String key) {
		Cursor cursor;
		String value = "";

		SQLiteDatabase db = new Sql().db;
		String table = "kv";
		String[] columns = new String[] { "key", "value" };
		String selection = "key=?";
		String[] selectionArgs = new String[] { key };
		String groupBy = null;
		String having = null;
		String orderBy = null;
		String limit = "1";

		cursor = db.query(table, columns, selection, selectionArgs, groupBy,
				having, orderBy, limit);

		if (cursor.moveToFirst()) {
			value = cursor.getString(cursor.getColumnIndex("value"));
		}
		db.close();
		return value;
	}

	/**
	 * kv表操作，设置对应key的value
	 * 
	 * @param key
	 * @param value
	 * @return 状态：false失败；true成功
	 */
	static public Boolean kv_set(String key, String value) {
		SQLiteDatabase db = new Sql().db;
		if(db.isDbLockedByCurrentThread()){
			Log.i("rex","真的被锁了");
		}

		ContentValues values = new ContentValues();
		values.put("key", key);
		values.put("value", value);
		long rowid = db.insert("kv", null, values);

		if (rowid == -1) {
			db.close();
			return true;
		} else {
			ContentValues values_update = new ContentValues();
			values_update.put("value", value);
			int i = db.update("kv", values_update, "key=?",
					new String[] { key });
			if (i > 0) {
				db.close();
				return true;
			}
		}

		db.close();
		return false;
	}

	/**
	 * 保存更新院系表到数据库
	 * 
	 * @param list
	 * @return
	 */
	static public boolean dep_update(String[] list) {
		SQLiteDatabase db = new Sql().db;
		ContentValues values = new ContentValues();

		if (!list.equals(null)) {
			for (int i = 0; i < list.length; i++) {
				String[] item = list[i].split(",");

				int dep_id = Integer.parseInt(item[0].trim());

				try {
					values.put("dep_id", dep_id);
					values.put("dep_name", item[1].trim());
					values.put("dep_rate", 0);
					values.put("dep_note", "");
				} catch (Exception e) {
					db.close();
					return false;
				}
				long rowid = db.insert("departments", null, values);
				values.remove("dep_id");
				if (rowid == -1) {
					db.update("departments", values, "dep_id=?",
							new String[] { dep_id + "" });
				}
				values.clear();
			}
			db.close();
			return true;
		}
		Log.i("rex", "list为空，没有执行任何数据库操作");
		db.close();
		return false;
	}

	/**
	 * 获取单条院系信息，按关键字key精确查询，匹配dep_id和dep_name
	 * 
	 * @param key
	 *            关键字
	 * @return
	 */
	static public int dep_get(String key) {
		if (key.equals(null)) {
			return 0;
		}

		
		return 0;
	}
}
