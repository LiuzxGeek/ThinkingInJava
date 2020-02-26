package com.java.thinking.radix;

/*
*@author:liuxian
*@date:2018年4月17日
*/
public class TestSixteen {
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(255 * 0 / 100));//
		System.out.println(Integer.toHexString(255 * 4 / 100));// 19
		System.out.println(Integer.toHexString(255 * 5 / 100));// cc
		System.out.println(Integer.toHexString(255 * 10 / 100));// 19
		System.out.println(Integer.toHexString(255 * 12 / 100));// 1e
		System.out.println(Integer.toHexString(255 * 13 / 100));// 21
		System.out.println(Integer.toHexString(255 * 15 / 100));// 26
		System.out.println(Integer.toHexString(255 * 20 / 100));// 33
		System.out.println(Integer.toHexString(255 * 25 / 100));// 3f
		System.out.println(Integer.toHexString(255 * 30 / 100));// 4c
		System.out.println(Integer.toHexString(255 * 40 / 100));// 66
		System.out.println(Integer.toHexString(255 * 50 / 100));// 7f
		System.out.println("40：" + Integer.toHexString(255 * 40 / 100));// 66
		System.out.println(Integer.toHexString(255 * 60 / 100));// 99
		System.out.println(Integer.toHexString(255 * 70 / 100));// b2
		System.out.println(Integer.toHexString(255 * 75 / 100));// bf
		System.out.println(Integer.toHexString(255 * 80 / 100));// cc
		System.out.println(Integer.toHexString(255 * 85 / 100));// d8
		System.out.println(Integer.toHexString(255 * 90 / 100));// e5
		System.out.println(Integer.toHexString(255 * 100 / 100));// ff
		// int lastTime = 40000;
		// int progress = (int) (100 * lastTime / 60 / 1000);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		long left = 109088397382l;
		System.out.println("ad" + left);
		System.out.println(100 * 90 / 100 / 20);
	}
}
