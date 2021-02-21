package com.java.thinking.leetcode.sim;

public class RemoveChar {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int j = -1;
		int count = nums.length;
		for (int i = 0, size = nums.length; i < size; i++) {
			if (nums[i] == val) {
				if (j == -1) {
					// 赋值初始位置
					j = i;
				}
				// 数量+1
				count--;
			} else {
				if (j != -1) {
					nums[j++] = nums[i];
				}
			}
		}
		return count;
	}
}
