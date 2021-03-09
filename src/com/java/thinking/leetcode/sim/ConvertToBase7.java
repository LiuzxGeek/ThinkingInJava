package com.java.thinking.leetcode.sim;

public class ConvertToBase7 {
	public static String convertToBase7(int num) {
		boolean isNeg = num < 0;
		num = Math.abs(num);
		int[] result = null;
		if (num < 7) {
			result = new int[1];
		}
		while (num >= 7) {
			int count = 0;
			int tem = num;
			while (tem >= 7) {
				tem /= 7;
				count++;
			}
			if (result == null) {
				result = new int[count + 1];
			}
			result[count] = tem;
			num -= tem * Math.pow(7, count);
		}
		if (num > 0) {
			result[0] = num;
		}
		StringBuilder builder = new StringBuilder(isNeg ? "-" : "");
		for (int i = result.length - 1; i >= 0; i--) {
			builder.append(String.valueOf(result[i]));
		}
		return builder.toString();
	}

	public static String convertToBase72(int num) {
		boolean isNeg = num < 0;
		num = Math.abs(num);
		int[] result = null;
		if (num < 7) {
			result = new int[1];
		}
		while (num >= 7) {
			int count = 0;
			int tem = num;
			while (tem >= 7) {
				tem /= 7;
				count++;
			}
			if (result == null) {
				result = new int[count + 1];
			}
			result[count] = tem;
			num -= tem * Math.pow(7, count);
		}
		if (num > 0) {
			result[0] = num;
		}
		StringBuilder builder = new StringBuilder(isNeg ? "-" : "");
		for (int i = result.length - 1; i >= 0; i--) {
			builder.append(String.valueOf(result[i]));
		}
		return builder.toString();
	}

	public static String convertToBase2(int num) {
		boolean isNeg = num < 0;
		num = Math.abs(num);
		int[] result = null;
		if (num < 2) {
			result = new int[1];
		}
		while (num >= 2) {
			int count = 0;
			int tem = num;
			while (tem >= 2) {
				tem /= 2;
				count++;
			}
			if (result == null) {
				result = new int[count + 1];
				for (int i = 0; i < count; i++) {
					result[i] = 0;
				}
			}
			result[count] = tem;
			num -= tem * Math.pow(2, count);
		}
		if (num > 0) {
			result[0] = num;
		}
		StringBuilder builder = new StringBuilder(isNeg ? "-" : "");
		for (int i = result.length - 1; i >= 0; i--) {
			builder.append(String.valueOf(result[i]));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToBase7(16));
		System.out.println(convertToBase2(3));
	}
}
