package com.java.thinking.leetcode;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Integer maxCount = null;
		int length = nums.length - 1;
		while (length > -1) {
			int tempCount = 0;
			for (int i = length; i < nums.length; i++) {
				tempCount += nums[i];
				if (maxCount == null || tempCount > maxCount) {
					maxCount = tempCount;
				}
			}
			length--;
		}
		return maxCount;
	}

	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// 用于记录上次最大的值
		int maxCount = nums[0];
		// 用于记录临时最大值
		int temCount = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (nums[i] > temCount && temCount < 0) {
					// 当前数大于0，同时大于临时最大值，且临时小于0，则采用赋值操作
					temCount = nums[i];
				} else {
					temCount += nums[i];
				}
			} else {
				// 目的是为了连接后面的数字
				if (nums[i] > temCount) {
					// 防止都是负数
					temCount = nums[i];
				} else {
					temCount += nums[i];
				}
			}
			maxCount = Math.max(maxCount, temCount);
		}
		return maxCount;
	}

	public int maxSubArray3(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// 用于记录上次最大的值
		int maxCount = nums[0];
		// 用于记录临时最大值
		int temCount = 0;
		for (int i = 1; i < nums.length; i++) {
			if (temCount > 0) {
				temCount += nums[i];
			} else {
				temCount = nums[i];
			}
			maxCount = Math.max(maxCount, temCount);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		MaxSubArray subArray = new MaxSubArray();
		System.out.println(subArray.maxSubArray3(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
