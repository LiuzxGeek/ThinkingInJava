package com.java.thinking.leetcode.sim;

/**
 * 图像反转算法
 * 
 * @author fred
 *
 */
public class FlipAndInvertImage {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			int[] arr = A[i];
			int len = arr.length;
			int start = 0, end = len - 1;
			while (start >= end) {
				if (len % 2 == 1 && len / 2 == start) {
					arr[start] = 1 - arr[start];
					break;
				}
				int tem = arr[start];
				arr[start] = 1 - arr[end];
				arr[end] = 1 - tem;
				start++;
				end--;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		char ch = 0;
		System.out.println(1000 / 10 / 10);
	}
}
