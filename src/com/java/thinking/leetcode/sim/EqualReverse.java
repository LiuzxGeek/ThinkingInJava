package com.java.thinking.leetcode.sim;

public class EqualReverse {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		char[] ch = String.valueOf(x).toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[ch.length - i - 1]) {
				return false;
			}
			if (i >= ch.length / 2) {
				break;
			}
		}
		return true;
	}

	public boolean isPalindrome2(int x) {
		return isPalind(x);
	}

	public boolean isPalind(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int o = x;
		// 最后1位
		int t = x % 10;
		int c = 0;
		while (x >= 10) {
			// 第1位
			x = x / 10;
			// 轮询次数
			c++;
		}
		if (t != x) {
			return false;
		}
		// 剩余的数字
		int r = (int) ((o - x * Math.pow(10, c)) / 10);
		if (r == 0)
			return true;
		// 通常需要超过1倍，解决中间有0的问题
		double m = r / Math.pow(10, c - 2);
		while (m < 1) {
			// 错过的次数
			m *= 10;
			if (r % 10 != 0) {
				return false;
			}
			r = r / 10;
		}
		return isPalind(r);
	}

	public boolean isPalindrome3(int x) {
		if (x < 0) {
			return false;
		}
		int tem = x;
		long t = 0;
		while (tem != 0) {
			int uni = tem % 10;
			t = t * 10 + uni;
			tem /= 10;
		}
		return x == t;
	}

	public static void main(String[] args) {
		EqualReverse equalReverse = new EqualReverse();
		System.out.println(equalReverse.isPalindrome3(1001));
	}
}
