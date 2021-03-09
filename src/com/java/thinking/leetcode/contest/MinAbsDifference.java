package com.java.thinking.leetcode.contest;

import java.util.Arrays;

public class MinAbsDifference {

	public int minAbsDifference(int[] nums, int goal) {
		int sum = Arrays.stream(nums).sum();
		Arrays.sort(nums);
		int differ = sum - goal;
		if (differ > 0) {
			// sum大，找正值，需减肥
			int posDiffer = differ;
			for (int i = nums.length - 1; i >= 0; i--) {
				int tem = minDifferPos(nums, i, differ);
				if (Math.abs(posDiffer) > Math.abs(tem)) {
					posDiffer = tem;
				}
			}
			differ = posDiffer;
		} else {
			// goal大，找负值，需增肥
			int negDiffer = differ;
			for (int i = 0; i < nums.length; i++) {
				int tem = minDifferNeg(nums, i, differ);
				if (Math.abs(negDiffer) > Math.abs(tem)) {
					negDiffer = tem;
				}
			}
			differ = negDiffer;
		}
		return Math.abs(differ);
	}

	private int minDifferPos(int[] nums, int index, int differ) {
		for (int i = index; i >= 0; i--) {
			if (nums[i] > 0) {
				if (differ >= nums[i]) {
					differ -= nums[i];
				}
			} else {
				if (differ >= nums[i]) {
					differ -= nums[i];
				}
			}
		}
		return differ;
	}

	private int minDifferNeg(int[] nums, int index, int differ) {
		for (int i = index; i >= 0; i--) {
			if (nums[i] < 0) {
				if (differ < 0 && differ >= nums[i]) {
					differ -= nums[i];
				} else {
					break;
				}
			} else {
				break;
			}
		}
		return differ;
	}

	public static void main(String[] args) {
		MinAbsDifference difference = new MinAbsDifference();
		int arr[] = { 7, -9, 15, -2 };
		System.out.println(difference.minAbsDifference(arr, 5));
	}
}
