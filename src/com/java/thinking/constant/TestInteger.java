package com.java.thinking.constant;

public class TestInteger {
	public static void main(String[] args) {
		int size = 0x7fffffff;// Integer.MAX_VALUE
		Integer oral = 2;
		for (int i = 0; i < 4; i++) {
			oral *= oral;
		}
		for (int i = 0; i < 15; i++) {
			oral *= 2;
		}
		System.out.println(size == oral - 1);
		System.out.println(size);
		System.out.println(oral * -1);
	}
}
