package com.java.thinking.math;

import java.text.DecimalFormat;

/*
*@author:liuxian
*@date:2018年5月4日
*/
public class TestMath {
	public static String getDataFormat(double number) {
		DecimalFormat format = new DecimalFormat("#.00");
		if (number > 100000000) {
			String first = format.format(number / 100000000);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 1);
			}
			return (result + "亿");
		} else if (number > 10000) {
			String first = format.format(number / 10000);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 1);
			}
			return (result + "万");
		}
		return String.valueOf((int) number);
	}

	public static void main(String[] args) {
		System.out.println(getDataFormat(1560));
		System.out.println(getDataFormat(10400));
		System.out.println(getDataFormat(156000000));
		// 每三位以逗号进行分隔。
		System.out.println(new DecimalFormat(",###").format(1015521743));// 299,792,458
	}
}
