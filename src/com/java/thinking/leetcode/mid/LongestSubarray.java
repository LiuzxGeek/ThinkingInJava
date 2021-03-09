package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubarray {
	public static int longestSubarray(int[] nums, int limit) {
		int ans = 1;
		int min = 0, max = 0;
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 0, nums[0] });
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[max]) {
				max = i;
				list.add(new int[] { i, nums[i] });
				while (Math.abs(nums[max] - nums[min]) > limit) {
					// 删除所有比此下标都小的数字
					Iterator<int[]> iterator = list.iterator();
					int[] first = list.get(0);
					while (iterator.hasNext()) {
						int[] bean = iterator.next();
						if (bean[0] <= first[0]) {
							iterator.remove();
						}
					}
					min = list.get(0)[0];
				}
			} else if (nums[i] < nums[min]) {
				// 比最小的还小
				min = i;
				list.add(0, new int[] { i, nums[i] });
				// 绝对值大于限制
				while (Math.abs(nums[max] - nums[min]) > limit) {
					// 删除前面所有下标比此最大值小的数字
					Iterator<int[]> iterator = list.iterator();
					int[] last = list.get(list.size() - 1);
					while (iterator.hasNext()) {
						int[] bean = iterator.next();
						if (bean[0] <= last[0]) {
							iterator.remove();
						}
					}
					if (list.size() == 0) {
						max = min;
					} else {
						max = list.get(list.size() - 1)[0];
					}
				}
			} else {
				int l = 0;
				int r = list.size() - 1;
				int m = -1;
				while (l <= r) {
					m = l + r >> 1;
					if (nums[i] > list.get(m)[1]) {
						l = m + 1;
					} else if (nums[i] < list.get(m)[1]) {
						r = m - 1;
					} else {
						break;
					}

				}
				list.add(l, new int[] { i, nums[i] });
			}
			ans = Math.max(ans, list.size());
		}
		return ans;
	}

	public static int longestSubarray2(int[] nums, int limit) {
		int ans = 0, left = 0, right = 0, len = nums.length;
		// 值+数量
		TreeMap<Integer, Integer> map = new TreeMap<>();
		while (right < len) {
			map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
			while (map.lastKey() - map.firstKey() > limit) {
				int count = map.getOrDefault(nums[left], 0) - 1;
				if (count == 0) {
					map.remove(nums[left++]);
				} else {
					map.put(nums[left++], count);
				}
			}
			ans = Math.max(ans, ++right - left);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 79, 52, 79, 3 };
		int limit = 63;
		System.out.println(longestSubarray2(nums, limit));
	}
}
