package com.java.thinking.leetcode.mid;

public class GenerateMatrix {
	public static int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0, x = 0, y = 0;
		int arrow = 0, value = 1;
		int max = (int) Math.pow(n, 2);
		while (true) {
			if (y >= n || y < 0 || x >= n || x < 0 || value > max) {
				break;
			}
			if (arrow == 0) {
				// 右
				if (x == n - 1 - x2) {
					y1++;
					arrow = 1;
					// 向下
					ans[y++][x] = value++;
				} else {
					ans[y][x++] = value++;
				}
			} else if (arrow == 1) {
				// 下
				if (y == n - 1 - y2) {
					x2++;
					arrow = 2;
					// 向左
					ans[y][x--] = value++;
				} else {
					ans[y++][x] = value++;
				}
			} else if (arrow == 2) {
				// 左
				if (x == x1) {
					y2++;
					arrow = 3;
					// 向上
					ans[y--][x] = value++;
				} else {
					ans[y][x--] = value++;
				}
			} else if (arrow == 3) {
				// 上
				if (y == y1) {
					x1++;
					arrow = 0;
					// 向右
					ans[y][x++] = value++;
				} else {
					ans[y--][x] = value++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(generateMatrix(2));
		// 0 2 4 5 6 8
		// 1,3,7,9
	}
}
