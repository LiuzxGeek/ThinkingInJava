package com.java.thinking.leetcode.sim;

public class DeleteDuplicate {

	public int[] removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int j = 0;
		for (int i = 1, size = nums.length; i < size; i++) {
			if (nums[i] > nums[j]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
		int[] nums = deleteDuplicate.removeDuplicates(new int[] { 1, 1, 2, 2 });
		for (int num : nums) {
			System.out.println(num);
		}
	}

}
