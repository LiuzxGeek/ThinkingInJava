package com.java.thinking.leetcode;

public class MaxArray {
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		int[] res = new int[k];
		if (m + n >= k) {
			int[] tar = new int[k];
			int lastIndex1 = 0;
			for (int i = 0; i < nums1.length; i++) {
				lastIndex1++;
				tar[i] = nums1[i];
				if (i == k - 1) {
					if (bigger(tar, res)) {
						res = tar;
					}
					break;
				}
			}
			if (lastIndex1 < k) {
				// 不足

			}
		}
		return res;
	}

	public static boolean bigger(int[] nums1, int[] nums2) {
		for (int i = 0, j = 0; i < nums1.length; i++, j++) {
			if (j == nums2.length) {
				// 完全相等
				return false;
			}
			if (nums1[i] == nums2[j]) {
				continue;
			} else if (nums1[i] > nums2[j]) {
				return true;
			} else if (nums1[i] < nums2[j]) {
				return true;
			}
		}
		return false;
	}

	public static int[] getMax(int[] nums, int k) {
		int[] tar = new int[k];
		return tar;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 6, 7 };// { 3, 4, 6, 5 };
		int[] nums2 = new int[] { 2, 1, 2, 8, 9, 3 };// { 6, 0, 4 };//
		int[] result = maxNumber(nums1, nums2, 5);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
