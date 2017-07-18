package com.java.thinking.alto;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.google.gson.JsonObject;

public class TestBase64 {
	public static void main(String[] args) {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("cd", "ab");
		jsonData.addProperty("ad", "cd");
		String base64Data = base64Msg(jsonData.toString());
		System.out.println(base64Data);
		String requestData = mixMsg(base64Data);
		System.out.println(requestData);
	}

	private static String base64Msg(String msg) {
		try {
			return new String(Base64.getEncoder().encode(msg.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 高低位互换
	 */
	private static String mixMsg(String msg) {
		char[] chs = msg.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			chs[i] = (char) ((chs[i] << 8 & 0xff00) | chs[i] >> 8);
		}

		return new String(chs);
	}
}
