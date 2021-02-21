package com.java.thinking.leetcode.sim;

public class ArrangeCoins {
	public int arrangeCoins(int n) {
		int count = 0;
		while (n > 0) {
			n -= ++count;
		}
		if (n < 0) {
			// 说明多计算了1位
			count--;
		}
		return count;
	}

	public int arrangeCoins2(int n) {
		int s = 1;
		int e = n;
		long m = 0;
		while (s < e) {
			m = e + (long) s >> 1;
			long sum = (long) (m + 1) * m / 2;
			if (sum > n) {
				e = (int) m;
			} else {
				s = (int) m + 1;
			}
		}
		return (int) m;
	}

	public int arrangeCoins3(int n) {
		return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
	}

	public static void main(String[] args) {
		ArrangeCoins coins = new ArrangeCoins();
		System.out.println(coins.arrangeCoins2(2147483647));
	}
}
