/**
 * 掌上长大-长江大学校园安卓应用
 *
 * Copyright (C) 2014-2016 Rex Lee <duguying2008@gmail.com>
 *
 * This program is free and opensource software; 
 * you can redistribute it and/or modify
 * it under the terms of the MIT License
 */
package com.rex.yangtzeu.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Environment;

public class Path {
	// SD卡就绪状态
	public static boolean sdcard_status = Environment.MEDIA_MOUNTED
			.equals(Environment.getExternalStorageState());
	// 主文件夹名
		public static String data_home = "data.rex.yuol";
	// 测试文件
	public static File testfile = new File(Path.check_dir()+"/rextest.txt");
	

	/**
	 * SD卡路径
	 * 
	 * @return
	 */
	public static File sdcard_path() {
		if (!sdcard_status) {
			return null;
		} else {
			return Environment.getExternalStorageDirectory();
		}
	}

	/**
	 * 外置SD卡路径
	 * 
	 * @return
	 */
	public static File sdcard2_path() {
		if (!sdcard_status) {
			return null;
		}
		File sdcard2 = new File(Path.sdcard_path(), "../sdcard2");
		if (sdcard2.exists()) {
			return sdcard2;
		} else {
			return Path.sdcard_path();
		}
	}
	
	/**
	 * 检查目录是否存在，不存在则创建
	 * @return 返回目录路径
	 */
	public static String check_dir() {
		File destDir = new File(Path.sdcard2_path().toString()+"/"+Path.data_home+"/");
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		return destDir.toString();
	}

	// 文件写入测试
	public static void save_file(File file, String content) {
		FileOutputStream fops;
		try {
			fops = new FileOutputStream(file);
			fops.write(content.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
