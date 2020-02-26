package com.java.thinking.date;

import java.text.ParseException;
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

	public static long getCurrentTimeStamp() {
		long timestamp = (new Date()).getTime();
		timestamp = timestamp / 1000;
		return timestamp;
	}

	private static void changeTimeFormat() {
		String s = "Sun Sep 29 09:34:34 +0800 2019";// "Sun Sep 02 2012 08:00:00 GMT+08:00";//Sun Sep 29 09:34:34 +0800
													// 2019
		SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
		try {
			Date date = sf.parse(s);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
			date.getTime();
			System.out.println(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// System.out.println(getStamp2Date("1493198873792"));
		// System.out.println(getStamp2Date("1493198873953"));
		// System.out.println(getCurrentTimeStamp());
		// changeTimeFormat();
		Date date = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
	}
}
