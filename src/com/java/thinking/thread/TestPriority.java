package com.java.thinking.thread;

/*
*@author:liuxian
*@date:2018年10月19日
*/
public class TestPriority {
	public static void main(String[] args) {
		int priority = Math.max(Thread.MIN_PRIORITY,
				Math.min(Thread.MAX_PRIORITY, Integer.getInteger("name", Thread.NORM_PRIORITY)));
		System.out.println(priority);
	}
}
