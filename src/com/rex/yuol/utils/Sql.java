package com.rex.yuol.utils;

import java.io.File;

import com.rex.yuol.config.Path;

import android.content.Context;
import android.database.sqlite.*;

public class Sql {

	public static SQLiteDatabase db_open() {
		// 打开或创建test.db数据库
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
				Path.check_dir() + "/rex.db", null);

		db.execSQL("DROP TABLE IF EXISTS person");
		// 创建person表
		db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");

		// 关闭当前数据库
		db.close();
		return db;

	}

}
