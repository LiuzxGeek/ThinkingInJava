package com.java.thinking.leetcode.mid;

public class MinimumEffortPath {
	private int mMinCount = -1;
	private int endHeight;
	private int endColumns;

	public int minimumEffortPath(int[][] heights) {
		endHeight = heights.length;
		endColumns = heights[0].length;
		minimumEffortPath(heights, endHeight - 1, endColumns - 1, -1, 0, true);
		return mMinCount;
	}

	public void minimumEffortPath(int[][] heights, int i, int j, int count, int lastPoint, boolean up) {
		if (count == -1) {
			count = 0;
		} else {
			int tem = Math.abs(heights[i][j] - lastPoint);
			if (tem > count) {
				count = tem;
			}
		}
		if (mMinCount != -1 && mMinCount < count) {
			return;
		}
		System.out.println(i + ":" + j + "=" + heights[i][j] + " " + count);
		if (up) {
			if (i > 0) {
				minimumEffortPath(heights, i - 1, j, count, heights[i][j], up);
			}
			if (j > 0) {
				minimumEffortPath(heights, i, j - 1, count, heights[i][j], up);
				if (i + 1 <= endHeight - 1) {
					minimumEffortPath(heights, i + 1, j - 1, count, heights[i][j], false);
				}
			}
		} else {
			if (i + 1 <= endHeight - 1) {
				minimumEffortPath(heights, i + 1, j, count, heights[i][j], false);
			}
			if (j > 0) {
				minimumEffortPath(heights, i, j - 1, count, heights[i][j], true);
			}
		}
		if (i == 0 && j == 0) {
			if (mMinCount == -1 || count < mMinCount) {
				mMinCount = count;
			}
			return;
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
				{ 1, 1, 1, 2, 1 } };
		// arr = new int[][] { { 1, 3, 2 }, { 4, 5, 6 } };
		// arr = new int[][] { { 1, 2, 1, 1, 1 }, { 1, 1, 1, 2, 1 } };
		 arr = new int[][] { { 8, 3, 2, 5, 2, 10, 7, 1, 8, 9 }, { 1, 4, 9, 1, 10, 2,
		 4, 10, 3, 5 },
		 { 4, 10, 10, 3, 6, 1, 3, 9, 8, 8 }, { 4, 4, 6, 10, 10, 10, 2, 10, 8, 8 },
		 { 9, 10, 2, 4, 1, 2, 2, 6, 5, 7 }, { 2, 9, 2, 6, 1, 4, 7, 6, 10, 9 }, { 8, 8,
		 2, 10, 8, 2, 3, 9, 5, 3 },
		 { 2, 10, 9, 3, 5, 1, 7, 4, 5, 6 }, { 2, 3, 9, 2, 5, 10, 2, 7, 1, 8 },
		 { 9, 10, 4, 10, 7, 4, 9, 3, 1, 6 } };
		System.out.println((new MinimumEffortPath()).minimumEffortPath(arr));
	}
}
