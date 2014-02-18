package com.rex.yuol.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Environment;

public class Path {
	// SD卡就绪状态
	public static boolean sdcard_status = Environment.MEDIA_MOUNTED
			.equals(Environment.getExternalStorageState());
	// 测试文件
	public static File testfile = new File(Path.sdcard2_path(), "rextest.txt");

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
