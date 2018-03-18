package com.java.thinking.constant;

public class TestInteger {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY = (1 << COUNT_BITS) - 1;

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
		System.out.println(COUNT_BITS);
		System.out.println(CAPACITY);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(8 >> 1);
		System.out.println(8 << 1);
	}
}
