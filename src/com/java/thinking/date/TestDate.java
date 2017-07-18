package com.java.thinking.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {
	public static String getStamp2Date(String date) {
		try {
			long ss = Long.parseLong(date);
			long l = ss;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			return sdf.format(new Date(l));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(getStamp2Date("1493198873792"));
		System.out.println(getStamp2Date("1493198873953"));
	}
}
