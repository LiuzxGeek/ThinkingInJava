package com.java.thinking.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
*@author:liuxian
*@date:2019年5月30日
*/
public class TestFormat {
	public static void main(String[] args) {
		String format = "YYYY-MM-DD'T'hh:mm:ss'Z'";
		System.out.println(getStamp2Date(System.currentTimeMillis(), format));
	}

	public static String getStamp2Date(long timestamp, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
			return sdf.format(new Date(timestamp));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
