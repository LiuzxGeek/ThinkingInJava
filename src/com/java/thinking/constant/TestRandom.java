package com.java.thinking.constant;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/*
*@author:liuxian
*@date:2018年8月9日
*/
public class TestRandom {
	static Integer integer;

	private static void test1() {
		Random r1 = new Random(3);
		Random r2 = new Random(2);

		for (int i = 0; i < 100; i++) {
			System.out.println(r1.nextInt(4) + ", " + r2.nextInt());
		}
	}

	private static void testCase() {
		Random random = new Random();
		int i = 0;
		while (true) {
			System.out.println(random.nextInt(3));
			if (i++ > 10) {
				return;
			}
		}
	}

	private static void test2(double app) {
		Random random = new Random();
		int root = 0;
		int floor = 10;
		// 取root+random
		if (app > 20) {
			// 范围10-20
			root = 10;
			floor = 10;
		} else {
			// 范围1-5
			root = 1;
			floor = 4;
		}
		double little = app - (int) app;
		System.out.println(little);
		double result = root + random.nextInt(floor) + little;
		// 两位小数
		DecimalFormat format = new DecimalFormat("#.00");
		format.setGroupingSize(0);
		format.setRoundingMode(RoundingMode.FLOOR);
		String dis = format.format(result);
		while (dis.endsWith("0")) {
			dis = dis.substring(0, dis.length() - 1);
		}
		if(dis.endsWith(".")) {
			dis = dis.substring(0, dis.length() - 1);
		}
		System.out.println(dis);
	}

	public static void main(String[] args) {
		// testCase();
		// int a = integer;
		// System.out.println(integer);
		// System.out.println(a);
		test2(20.03);
	}
}
