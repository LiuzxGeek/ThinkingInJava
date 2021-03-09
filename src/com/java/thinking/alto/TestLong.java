package com.java.thinking.alto;

import java.text.DecimalFormat;

public class TestLong {
	public static void main(String[] args) {
		long i = 1234;
		System.out.println(Long.toBinaryString(i));// 2进制
		System.out.println(Long.toHexString(i));// 16进制
		System.out.println(Long.toOctalString(i));// 8进制
		System.out.println(Long.toString(i));
		System.out.println(getDataFormat(9999999999d));
		System.out.println(Integer.MAX_VALUE);
	}

	public static String getDataFormat(double number) {
		DecimalFormat format = new DecimalFormat("#.00");
		if (number > 100000000) {
			String first = format.format(number / 100000000);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 2);
			}
			return (result + "亿");
		} else if (number > 10000) {
			String first = format.format(number / 10000);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 2);
			}
			return (result + "万");
		}
		return String.valueOf((int) number);
	}
}
