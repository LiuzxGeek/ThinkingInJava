package com.java.thinking.radix;

/*
*@author:liuxian
*@date:2018年4月17日
*/
public class TestSixteen {
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(255 * 80 / 100));
		System.out.println(Integer.toHexString(255 * 15 / 100));
		System.out.println(Integer.toHexString(255 * 20 / 100));// 33
		int lastTime = 40000;
		int progress = (int) (100 * lastTime / 60 / 1000);
		System.out.println(progress);
	}
}
