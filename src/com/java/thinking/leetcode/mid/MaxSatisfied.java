package com.java.thinking.leetcode.mid;

public class MaxSatisfied {
	public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int max = 0;
		int len = customers.length;
		for (int i = 0; i < len; i++) {
			int tem = 0;
			if (len - i < X) {
				break;
			}
			for (int t = i; t < i + X; t++) {
				tem += customers[t];
			}
			for (int j = 0; j < len; j++) {
				if (j >= i && j <= i + X - 1) {
					continue;
				}
				if (grumpy[j] == 0) {
					tem += customers[j];
				}
			}
			max = Math.max(tem, max);
		}
		return max;
	}

	public static int maxSatisfied2(int[] customers, int[] grumpy, int X) {
		int max = 0;
		int len = customers.length;
		// 不生气时的客户总数
		int zeroSum = 0;
		// X分钟内的客户总数
		int xSum = 0;
		for (int i = 0; i < len; i++) {
			int tem = zeroSum;
			if (len - i < X) {
				break;
			}
			if (xSum == 0) {
				for (int t = i; t < i + X; t++) {
					xSum += customers[t];
				}
			} else {
				xSum -= customers[i - 1];
				xSum += customers[i + X - 1];
			}
			tem += xSum;
			for (int j = i + X; j < len; j++) {
				if (grumpy[j] == 0) {
					tem += customers[j];
				}
			}
			max = Math.max(tem, max);
			if (grumpy[i] == 0) {
				zeroSum += customers[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 }, grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int X = 3;
		System.out.println(maxSatisfied2(customers, grumpy, X));
	}
}
