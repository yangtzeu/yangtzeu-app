/**
 * 长大校园通-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.sqlite;

import com.rex.yangtzeu.config.Path;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Sql {
	private SQLiteDatabase db;

	public Sql() {
		this.db = SQLiteDatabase.openOrCreateDatabase(Path.check_dir()
				+ "/yangtzeu.db", null);
		db_init();
	}

	/**
	 * 获取数据库
	 * 
	 * @return
	 */
	public SQLiteDatabase getSQLiteDatabase() {
		return this.db;
	}

	/**
	 * 执行查询sql语句
	 * 
	 * @param sql
	 * @param selectionArgs
	 * @return
	 */
	public Cursor query(String sql, String[] selectionArgs) {
		synchronized (this) {
			return db.rawQuery(sql, selectionArgs);
		}
	}

	/**
	 * 执行非查询sql语句
	 * 
	 * @param sql
	 */
	public void exec(String sql) {
		synchronized (this) {
			db.execSQL(sql);
		}
	}

	/**
	 * 打开并创建数据表
	 * 
	 */
	private void db_init() {
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
		Cursor cursor = query(check_exist_table, null);
		int count = 0;
		if (cursor.moveToFirst()) {
			count = cursor.getInt(cursor.getColumnIndex("c"));
		}
		if (count == 0) {
			// 创建表
			// try {
			exec(create_table_sql);
			// } catch (Exception e) {
			// Toast.makeText(Yangtzeu.getInstance(), e.getMessage(),
			// Toast.LENGTH_LONG).show();
			// }
		}
		if (cursor.equals(null)) {
			cursor.close();
		}
	}

}
