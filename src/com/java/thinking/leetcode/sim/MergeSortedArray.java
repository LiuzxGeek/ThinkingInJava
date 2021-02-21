package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < n; i++) {
			list.add(nums2[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i = 0, size = list.size(); i < size; i++) {
			nums1[i] = list.get(i);
			System.out.println(nums1[i]);
		}
	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int startIndex = -1;
		for (int i = 0; i < n; i++) {
			// 处理边界值
			if (startIndex < m) {
				// 数值仍在范围内
				for (int j = startIndex == -1 ? 0 : startIndex; j < m; j++) {
					if (nums1[j] >= nums2[i]) {
						startIndex = j;
						break;
					}
				}
			}
			if (startIndex != -1) {
				if (nums2[i] > nums1[startIndex]) {
					// 说明没有更大的
					startIndex = m++;
				} else {
					// 处理m=0的情况
					++m;
					// 中间数据移位
					for (int j = m - 1; j > startIndex; j--) {
						// 数值后移
						nums1[j] = nums1[j - 1];
					}
				}
			} else {
				// 说明没有更大的
				startIndex = m++;
			}
			// 赋值后，指针移位
			nums1[startIndex++] = nums2[i];
		}
		for (int i = 0; i < m; i++) {
			System.out.println(nums1[i]);
		}
	}

	public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
		int[] nums = new int[m + n];
		int[] left = nums1;
		int[] right = nums2;
		int leftSize = m;
		int rightSize = n;
		if (m < n) {
			left = nums2;
			right = nums1;
			leftSize = n;
			rightSize = m;
		}
		int index = 0;
		int jIndex = 0;
		// left是否先轮询结束
		boolean hasAdd = false;
		for (int i = 0; i < leftSize; i++) {
			for (int j = jIndex; j < rightSize; j++) {
				if (right[j] > left[i]) {
					if (i < leftSize - 1) {
						break;
					} else if (!hasAdd) {
						hasAdd = true;
						nums[index++] = left[i];
					}
				}
				nums[index++] = right[j];
				// 记录j值，以便下次循环
				jIndex = j + 1;
			}
			if (!hasAdd) {
				nums[index++] = left[i];
			}
		}
		return nums;
	}

	public void merge4(int[] nums1, int m, int[] nums2, int n) {
		n--;
		int i = m + n;
		m--;
		while (n >= 0) {
			if (m >= 0 && nums1[m] > nums2[n]) {
				// 比较最大值，从后面开始放，谁大就放谁
				nums1[i--] = nums1[m--];
			} else {
				nums1[i--] = nums2[n--];
			}
		}
	}

	public static void main(String[] args) {
		MergeSortedArray array = new MergeSortedArray();
		int[] nums = array.merge3(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
