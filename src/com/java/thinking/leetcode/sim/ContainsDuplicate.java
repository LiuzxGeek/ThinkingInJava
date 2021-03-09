package com.java.thinking.leetcode.sim;

import java.util.Arrays;

public class ContainsDuplicate {

	static volatile boolean isEqual = false;

	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return isEqual;
		qkSourt(nums, 0, nums.length);
		return isEqual;
	}

	public boolean containsDuplicate2(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return false;
		Arrays.sort(nums);
		int target = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (target == nums[i]) {
				return true;
			} else {
				target = nums[i];
			}
		}
		return false;
	}

	private static void qkSourt(int[] a, int start, int end) {
		if (a.length < 0) {
			return;
		}
		if (start >= end) {
			return;
		}
		int left = start;
		int right = end;
		int temp = a[left];
		while (left < right) {
			while (left < right && a[right] >= temp) {
				if (a[right] == temp) {
					isEqual = true;
					return;
				}
				right--;
			}
			a[left] = a[right];
			while (left < right && a[left] <= temp) {
				if (a[left] == temp) {
					isEqual = true;
					return;
				}
				left++;
			}
			a[right] = a[left];
		}
		a[left] = temp;
		qkSourt(a, start, left - 1);
		qkSourt(a, left + 1, end);
	}
}
