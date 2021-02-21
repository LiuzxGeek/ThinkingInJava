package com.java.thinking.leetcode.sim;

import java.util.Arrays;

public class FloodFill {
	/**
	 * 
	 * @param image
	 * @param sr
	 *            行
	 * @param sc
	 *            列
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int value = image[sr][sc];
		if (value != newColor) {
			floodFill(image, sr, sc, newColor, value);
		}
		return image;
	}

	public void floodFill(int[][] image, int sr, int sc, int newColor, int value) {
		if (sr >= 0 && sc >= 0 && image.length > sr && image[sr].length > sc) {
			if (image[sr][sc] == value) {
				image[sr][sc] = newColor;
				floodFill(image, sr + 1, sc, newColor, value);
				floodFill(image, sr - 1, sc, newColor, value);
				floodFill(image, sr, sc + 1, newColor, value);
				floodFill(image, sr, sc - 1, newColor, value);
			}
		}
	}

	public static void main(String[] args) {
		FloodFill fill = new FloodFill();
		int[][] image = { { 0, 0, 0 }, { 1, 0, 0 } };
		System.out.println(image.length);
		System.out.println(image[1].length);
		System.out.println(image[1][0]);
		int sr = 1;
		int sc = 0;
		int newColor = 2;
		int[][] result = fill.floodFill(image, sr, sc, newColor);
		for (int[] res : result) {
			System.out.println(Arrays.toString(res));
		}
	}
}
