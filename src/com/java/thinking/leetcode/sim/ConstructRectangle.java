package com.java.thinking.leetcode.sim;

public class ConstructRectangle {
	public static int[] constructRectangle(int area) {
		int[] ans = new int[2];
		double sqrt = Math.sqrt(area);
		ans[0] = ans[1] = (int) sqrt;
		if (sqrt != ans[0]) {
			// 平方根不能除尽
			for (int i = ans[0]; i >= 1; i--) {
				// i一直在变小，所以只能做高
				if (area % i == 0) {
					ans[1] = i;
					ans[0] = area / i;
					break;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] attr = constructRectangle(35);
		System.out.println(attr[0] + "," + attr[1]);
		System.out.println(5 % 5);
		System.out.println(5 % 1);
	}
}
