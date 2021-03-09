package com.java.thinking.leetcode.mid;

import java.util.Stack;

public class Find132pattern {
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3)
			return false;
		Stack<Integer> stack = new Stack<>();
		int[] min = new int[nums.length];
		min[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			min[i] = Math.min(min[i - 1], nums[i]);
		for (int j = nums.length - 1; j >= 0; j--) {
			if (nums[j] > min[j]) {
				while (!stack.isEmpty() && stack.peek() <= min[j])
					stack.pop();
				if (!stack.isEmpty() && stack.peek() < nums[j])
					return true;
				stack.push(nums[j]);
			}
		}
		return false;
	}

	public boolean find132pattern2(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int fir = nums[0];
		Integer sec = null;
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (sec == null) {
				if (nums[i] > fir) {
					sec = nums[i];
				} else {
					// 指针后移
					fir = nums[i];
				}
			} else {
				if (nums[i] < sec && nums[i] > fir) {
					return true;
				} else {
					if (i == nums.length - 1 && index < i) {
						// 首个位置后移
						i = index++;
						sec = null;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Find132pattern find132pattern = new Find132pattern();
		int[] attr = { -2, 1, 2, -2, 1, 2 };// { 3, 5, 0, 3, 4 };
		System.out.println(find132pattern.find132pattern2(attr));
		char[] st = new char[4];
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i]+"]");
		}
	}
}
