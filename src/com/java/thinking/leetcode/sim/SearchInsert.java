package com.java.thinking.leetcode.sim;

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		int high = nums.length - 1;
		// 二分查找法
		int low = 0;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > target) {
				high = mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] == target) {
				return mid;
			}
		}
		return low;
	}

	public int delayInsert(int[] nums, int target) {
		int index = nums.length;
		int size = index;
		for (int i = 0; i < size; i++) {
			if (nums[i] >= target) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		SearchInsert insert = new SearchInsert();
		insert.searchInsert(new int[] { 8 }, 7);
	}
}
