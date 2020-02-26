package com.java.thinking.constant;

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

	public static void main(String[] args) {
		testCase();
//		int a = integer;
//		System.out.println(integer);
//		System.out.println(a);
	}
}
