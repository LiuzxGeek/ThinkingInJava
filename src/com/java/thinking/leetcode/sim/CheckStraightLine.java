package com.java.thinking.leetcode.sim;

public class CheckStraightLine {
	public static boolean checkStraightLine(int[][] coordinates) {
		double a = 0;
		double b = 0;
		int x1 = coordinates[0][0];
		int x2 = coordinates[1][0];
		int y1 = coordinates[0][1];
		int y2 = coordinates[1][1];
		int xDiffer = x2 - x1;
		int yDiffer = y2 - y1;
		int len = coordinates.length;
		if (xDiffer != 0 && yDiffer != 0) {
			a = 1.0 * yDiffer / xDiffer;
			b = y1 - x1 * a;
			for (int i = 2; i < len; i++) {
				if (coordinates[i][1] != a * coordinates[i][0] + b) {
					return false;
				}
			}
		} else if (xDiffer == 0) {
			for (int i = 2; i < len; i++) {
				if (coordinates[i][0] - coordinates[i - 1][0] != 0) {
					return false;
				}
			}
		} else if (yDiffer == 0) {
			for (int i = 2; i < len; i++) {
				if (coordinates[i][1] - coordinates[i - 1][1] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void printArray(int[][] arr) {
		System.out.println(arr.length);
		System.out.println(arr[0].length);
	}

	public static void main(String[] args) {
		int[][] coordinates = { { 2, 1, 2 }, { 4, 2, 3 } };
		System.out.println(checkStraightLine(coordinates));
		printArray(coordinates);
	}
}
