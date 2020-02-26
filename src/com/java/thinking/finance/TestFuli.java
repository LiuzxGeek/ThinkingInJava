package com.java.thinking.finance;

import java.util.concurrent.CountDownLatch;

/*
*@author:liuxian
*@date:2019年7月9日
*/
public class TestFuli {
	public static void main(String[] args) {
		double s = 1;
		for (int i = 0; i < 50; i++) {
			s *= 1.1;
		}
		System.out.println(30 * s);
		System.out.println(0x100);
		System.out.println(0x101);
		CountDownLatch countDownLatch; 
	}
}
