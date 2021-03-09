package com.java.thinking.leetcode.sim;

public class IsToeplitzMatrix {
	public static boolean isToeplitzMatrix(int[][] matrix) {
		for (int t = 0; t < matrix.length - 1; t++) {
			int len = t == 0 ? matrix[t].length : 1;
			// 从0个数组开始
			for (int i = 0; i < len; i++) {
				// 从0开始遍历此数组
				int y = i + 1;
				for (int j = t + 1; j < matrix.length; j++) {
					if (y > matrix[j].length - 1) {
						break;
					}
					// 遍历下一个数组的i+1元素
					int s = matrix[t][i];
					int c = matrix[j][y++];
					if (s != c) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 18 }, { 66 } };
		System.out.println(isToeplitzMatrix(matrix));
		 for(int t=0;;t++) {
			 
		 }
	}
}
