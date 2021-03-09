package com.java.thinking.leetcode.contest;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/check-if-array-is-sorted-and-rotated/
 * 
 * @author fred
 *
 */
public class CheckIfArrayIsSortedAndRotated {
	public static boolean check(int[] nums) {
		int len = nums.length;
		int[] B = new int[len];
		System.arraycopy(nums, 0, B, 0, len);
		Arrays.sort(B);
		Integer count = null;
		int targetCount = 1;
		for (int i = 1; i < len; i++) {
			if (B[i] == B[0]) {
				targetCount++;
			} else {
				break;
			}
		}
		// count=len+j-i
		if (targetCount > 1) {
			// 超过1个目标值
			for (int i = 0; i < len; i++) {
				if (nums[i] == B[0]) {
					if (count == null) {
						count = len - i;
					} else {
						if (nums[i] != B[(i + count) % len]) {
							count = null;
							i--;
						}
					}
				}
			}
		} else {
			// j==0;
			for (int i = 0; i < len; i++) {
				if (nums[i] == B[0]) {
					count = len - i;
					break;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (nums[i] != B[(i + count) % len]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 1, 2 };
		// arr = new int[] { 2, 1, 3, 4 };
		// arr = new int[] { 1, 2, 3 };
		// arr = new int[] { 1, 1, 1 };
		// arr = new int[] { 2, 1 };
		// [1, 2, 5, 5, 6, 6, 6, 9]
		arr = new int[] { 5, 5, 6, 6, 6, 9, 1, 2 };
		// arr = new int[] { 6, 10, 6 };
		// arr = new int[] { 6, 7, 7, 5 };
		System.out.println(check(arr));
	}
}
