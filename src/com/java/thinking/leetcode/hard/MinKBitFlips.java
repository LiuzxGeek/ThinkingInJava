package com.java.thinking.leetcode.hard;

public class MinKBitFlips {
	public static int minKBitFlips(int[] A, int K) {
		int len = A.length;
		int sum = 0;
		int ans = 0;
		boolean oneTurn = false;
		boolean lastTurn = false;
		for (int i = 0; i < len; i++) {
			if (K == 0 && A[i] == 0) {
				return -1;
			}
			if (sum-- > 0) {
				if (A[i] == 1) {
					A[i] = 0;
				} else {
					A[i] = 1;
				}
				lastTurn = true;
			} else {
				if (oneTurn && lastTurn) {
					i = i + 1 - K;
					oneTurn = false;
					lastTurn = false;
				}
				if (A[i] == 0) {
					oneTurn = true;
					sum = K - 1;
					A[i] = 1;
					ans++;
				}
			}
		}
		if (lastTurn) {
			// 代表循环结束
			for (int i = len + 1 - K; i < len; i++) {
				if (A[i] == 0) {
					return -1;
				}
			}
		}
		if (sum > 0) {
			ans = -1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 1, 0, 0 };
		int K = 3;
		System.out.println(minKBitFlips(A, K));
	}
}
