package com.java.thinking.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class BubblePath {
	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		// 排序
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		// 检查
		int low = points[0][0];
		int high = points[0][1];
		int result = 1;
		for (int aIndex = 1; aIndex < points.length; aIndex++) {
			int[] bttr = points[aIndex];
			if (bttr[0] >= low && bttr[0] <= high) {
				// 默认第1个数据，就是低位和高位，后面逐步缩小范围，最后囊括所有数据
				if (bttr[0] > low) {
					low = bttr[0];
				}
				if (bttr[1] < high) {
					high = bttr[1];
				}
				continue;
			} else {
				// 不符合，则使用新箭
				low = points[aIndex][0];
				high = points[aIndex][1];
			}
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		// points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		// int[][] points = { { 7, 15 }, { 6, 14 }, { 8, 12 }, { 3, 4 }, { 4, 13 }, { 6,
		// 14 }, { 9, 11 }, { 6, 12 },
		// { 4, 13 } };
		int[][] points = { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 },
				{ 2, 8 } };
		System.out.println(findMinArrowShots(points));
	}
}
