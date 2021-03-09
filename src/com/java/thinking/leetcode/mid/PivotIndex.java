package com.java.thinking.leetcode.mid;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PivotIndex {
	public int pivotIndex(int[] nums) {
		int leftSum = 0;
		if (nums.length > 0) {
			leftSum = nums[0];
		}
		int rightSum = 0;
		if (nums.length > 1) {
			rightSum = nums[nums.length - 1];
		}
		for (int i = 1, j = nums.length - 1; i < j; i++) {
			if (leftSum == rightSum) {
				return i;
			} else if (leftSum < rightSum) {
				leftSum += nums[i];
			} else {
				// 左边总要加上
				leftSum += nums[i];
				while (leftSum > rightSum && i < j) {
					rightSum += nums[--j];
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 7, 3, 6, 5, 6 };
		System.out.println((new PivotIndex()).pivotIndex(arr));
		System.out.println(Arrays.stream(arr).sum());
		Queue<int[]> queue=new LinkedList<>();
		Iterator<int[]> iterator = queue.iterator();
	}
}
