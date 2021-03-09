package com.java.thinking.licai;

public class FuliTest {
	public static void main(String[] args) {
		double sum = 14.4;
		double fi = 2000;
		for (int i = 0; i < 55; i++) {
			sum *= 1.045;
			if (sum > fi) {
				System.out.println(i + "年");
				break;
			}
		}
		System.out.println(sum);
	}
}
