package com.java.thinking.leetcode.sim;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int extra = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + extra;
			if (i == digits.length - 1) {
				sum += 1;
			}
			extra = sum / 10;
			digits[i] = sum % 10;
			if (sum <= 9) {
				break;
			} else {
				if (i == 0) {
					int[] attr = new int[digits.length + 1];
					attr[0] = 1;
					for (int j = 1; j < attr.length; j++) {
						attr[j] = digits[j - 1];
					}
					digits = attr;
				}
			}
		}
		return digits;
	}

	public static void main(String[] args) {
		PlusOne one = new PlusOne();
		int[] result = one.plusOne(new int[] { 9, 9 });
		for (int num : result) {
			System.out.println(num);
		}
	}
}
