package com.java.thinking.leetcode.sim;

public class ConvertInteger {
	public static int convertInteger(int A, int B) {
		String ac = Integer.toBinaryString(A);
		String bc = Integer.toBinaryString(B);
		System.out.println("A:" + ac);
		System.out.println("B:" + bc);
		int ans = 0, index = 0, aLen = ac.length(), bLen = bc.length();
		while (index < aLen || index < bLen) {
			if (index < aLen && index < bLen) {
				ans += ac.charAt(aLen - 1 - index) == bc.charAt(bLen - 1 - index) ? 0 : 1;
			} else if (index < aLen) {
				// 清算剩余的数字长度
				ans += aLen - index;
				break;
			} else {
				ans += bLen - index;
				break;
			}
			index++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(convertInteger(1, 200));
		System.out.println(2 ^ 2);
		System.out.println(2 ^ 1);
		System.out.println(0 ^ 0);
	}
}
