package com.java.thinking.data;

/*
*@author:liuxian
*@date:2019年5月14日
*测试小数
*/
public class TestRemainder {
	public static void main(String[] args) {
		System.out.println(getDoubleFormatString(1.01));
		System.out.println(getDoubleFormatString(2.1));
		System.out.println(getDoubleFormatString(3.0));
		System.out.println(getDoubleFormatString(5.1));
		System.out.println(getDoubleFormatString(6.00000d));
		System.out.println(getDoubleFormatString(1.10));
		System.out.println(get1BitData(6.00000d));
		System.out.println(get1BitData(1.01));
		System.out.println(get1BitData(1.0));
		System.out.println(get1BitData(1.10));
	}

	public static String getDoubleFormatString(double num) {
		// 方法一
		if (num % ((int) num) == 0) {
			return String.valueOf((int) num);
		}
		return String.valueOf(num);
	}

	public static String get1BitData(double number) {
		String first = String.valueOf(number);
		String second = first.substring(first.indexOf("."));
		if (second.length() > 1 && !second.endsWith("0")) {
			return String.valueOf(number);
		}
		return String.valueOf((int) number);
	}
}
