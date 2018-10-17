package com.java.thinking.logic;

import java.text.DecimalFormat;

/*
*@author:liuxian
*@date:2018年10月15日
*/
public class TestFormat {
	public static String parseDistance(double distance) {
		distance = distance < 0.1 ? 0.1 : distance;
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(distance);
	}

	public static void main(String[] args) {
		String result=parseDistance(0.01);
		System.out.println(result);
		System.out.println(result.equals("0,10"));
	}
}
