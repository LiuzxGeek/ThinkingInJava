package com.java.thinking.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;

final class UploadUtils {

	static volatile boolean readyUploadSuccess = false;

	/**
	 */
	static void uploadNebulaLog() {
		try {
			List<String> data = tryReadNebulaFile();
			String jsonData = getRequestParam(data);
			System.out.println(jsonData.replace("\\", ""));
		} catch (Exception e) {
		}
	}

	private static String getRequestParam(List<String> data) {
		try {
			JsonArray jsonArray = new JsonArray();
			for (String item : data) {
				jsonArray.add(item);
			}
			return jsonArray.toString();
		} catch (Exception e) {
			return "";
		}
	}

	private static List<String> tryReadNebulaFile() throws IOException {
		List<String> targetList = getJsonDataFromFile();
		return targetList;
	}

	private static List<String> getJsonDataFromFile() throws IOException {
		String jsonData = readFile("D:/nebula.json");
		return Arrays.asList(jsonData.split("\n"));
	}

	private static String readFile(String path) {
		try {
			File file = new File(path);

			// 给该文件加锁
			RandomAccessFile fis = new RandomAccessFile(file, "rw");
			FileChannel fcin = fis.getChannel();
			FileLock flin = null;
			// while (true) {
			// try {
			// flin = fcin.tryLock();
			// break;
			// } catch (Exception e) {
			// System.out.println("有写线程正在操作该文件，当前线程休眠100毫秒");
			// }
			// }
			byte[] buf = new byte[4096];
			StringBuffer sb = new StringBuffer();
			while ((fis.read(buf)) != -1) {
				sb.append(new String(buf, "utf-8"));
				buf = new byte[4096];
			}

			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
