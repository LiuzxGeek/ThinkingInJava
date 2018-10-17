package com.java.thinking.constant;

import java.util.Random;

/*
*@author:liuxian
*@date:2018年8月9日
*/
public class TestRandom {
	public static void main(String[] args) {
		Random r1 = new Random(100);
		Random r2 = new Random(100);

		for (int i = 0; i < 100; i++) {
			System.out.println(r1.nextInt(100) + ", " + r2.nextInt());
		}
	}
}
