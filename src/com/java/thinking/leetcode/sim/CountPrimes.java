package com.java.thinking.leetcode.sim;

public class CountPrimes {
	public static int countPrimes(int n) {
		int ans = 0;
		for (int i = n - 1; i > 1; i--) {
			// 10以内的手动处理
			if (i < 2) {
				break;
			} else if (i == 2) {
				ans += 1;
				break;
			} else if (i <= 4) {
				ans += 2;
				break;
			} else if (i <= 6) {
				ans += 3;
				break;
			} else if (i < 10) {
				ans += 4;
				break;
			} else if (i % 10 == 1 || i % 10 == 3 || i % 10 == 7 || i % 10 == 9) {
				// 10以外的，计算尾数后，满足除1和它本身，还能被其他数字整除的，叫质数
				ans += isPrime(i) ? 1 : 0;
			}
		}
		return ans;
	}

	private static boolean isPrime(int num) {
		int max = (int) Math.sqrt(num);
		// 最小为3，最大为平方根；能被2等偶数整除，则肯定不是质数
		for (int i = 3; i <= max; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(170));
	}
}
