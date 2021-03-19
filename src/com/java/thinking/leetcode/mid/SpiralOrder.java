package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SpiralOrder {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		int vc = matrix.length, hc = matrix[0].length;
		int x = 0, y = 0;
		int arrow = 0;
		while (true) {
			if (y >= vc || y < 0 || x >= hc || x < 0 || ans.contains(matrix[y][x])) {
				break;
			}
			ans.add(matrix[y][x]);
			if (arrow == 0) {
				// 右
				if (x == hc - 1 - x2) {
					y1++;
					arrow = 1;
					// 向下
					y++;
				} else {
					x++;
				}
			} else if (arrow == 1) {
				// 下
				if (y == vc - 1 - y2) {
					x2++;
					arrow = 2;
					// 向左
					x--;
				} else {
					y++;
				}
			} else if (arrow == 2) {
				// 左
				if (x == x1) {
					y2++;
					arrow = 3;
					// 向上
					y--;
				} else {
					x--;
				}
			} else if (arrow == 3) {
				// 上
				if (y == y1) {
					x1++;
					arrow = 0;
					// 向右
					x++;
				} else {
					y--;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(spiralOrder(matrix));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		TreeSet<Integer> treeSet = new TreeSet<>(map.values());
	}
}
