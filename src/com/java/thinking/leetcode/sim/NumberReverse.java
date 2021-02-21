package com.java.thinking.leetcode.sim;

public class NumberReverse {

	public int reverse(int x) {
		boolean isPositive = x > 0;
		// 转成正数进行处理
		int t = Math.abs(x);
		String s = String.valueOf(t);
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i >= ch.length / 2) {
				break;
			}
			char tem = ch[i];
			ch[i] = ch[ch.length - i - 1];
			ch[ch.length - i - 1] = tem;
		}
		try {
			int result = Integer.valueOf(new String(ch));
			if (!isPositive) {
				result = -result;
			}
			return result;
		} catch (Exception e) {

		}
		return 0;
	}

	public int reverse1(int x) {
		// 转成正数进行处理
		String s = String.valueOf(x);
		char[] ch = s.toCharArray();
		boolean isNeg = false;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '-') {
				isNeg = true;
				continue;
			}
			int extra = (isNeg ? 1 : 0);
			if (i >= (ch.length + extra) / 2) {
				break;
			}
			char tem = ch[i];
			ch[i] = ch[ch.length - i - 1 + extra];
			ch[ch.length - i - 1 + extra] = tem;
		}
		try {
			int result = Integer.valueOf(new String(ch));
			return result;
		} catch (Exception e) {

		}
		return 0;
	}

	public int reverse2(int x) {
		try {
			String result = new StringBuffer(String.valueOf(x)).reverse().toString();
			return Integer.valueOf(result);
		} catch (Exception e) {
			return 0;
		}
	}

	int reverse4(int x) {
		long b = 0;
		while (x != 0) {
			b = x % 10 + b * 10;
			x = x / 10;
		}
		return (b >= Integer.MAX_VALUE || b <= Integer.MIN_VALUE) ? 0 : (int) b;
	}

	public static void main(String[] args) {
		NumberReverse reverse = new NumberReverse();
		System.out.println(reverse.reverse4(-123));
		System.out.println(0x7fffffff - Integer.MAX_VALUE);
		int value = (int) (7 * Math.pow(16, 7) + 15 * Math.pow(16, 6) + 15 * Math.pow(16, 5) + 15 * Math.pow(16, 4)
				+ 15 * Math.pow(16, 3) + 15 * Math.pow(16, 2) + 15 * Math.pow(16, 1) + 15 * Math.pow(16, 0));
		System.out.println(value - Integer.MAX_VALUE);
	}
}
