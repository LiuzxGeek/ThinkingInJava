package com.java.thinking.alto;

public class TestLong {
	public static void main(String[] args) {
		long i = 1234;
		System.out.println(Long.toBinaryString(i));//2进制
		System.out.println(Long.toHexString(i));//16进制
		System.out.println(Long.toOctalString(i));//8进制
		System.out.println(Long.toString(i));
	}
}
