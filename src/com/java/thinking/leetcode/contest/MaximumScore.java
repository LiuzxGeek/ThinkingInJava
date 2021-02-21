package com.java.thinking.leetcode.contest;

public class MaximumScore {
	public int maximumScore(int a, int b, int c) {
		int score = 0;
		while ((a > 0 && b > 0) || (a > 0 && c > 0) || (c > 0 && b > 0)) {
			if (a >= b && b >= c) {
				a--;
				b--;
			} else if (a >= c && c >= b) {
				a--;
				c--;
			} else if (b >= a && a >= c) {
				a--;
				b--;
			} else if (b >= c && c >= a) {
				b--;
				c--;
			} else if (c >= a && a >= b) {
				c--;
				a--;
			} else if (c >= b && b >= a) {
				c--;
				b--;
			}
			score++;
		}
		return score;
	}
}
