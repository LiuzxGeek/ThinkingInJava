package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> all = new ArrayList<>();
		if (nums != null && nums.length > 2) {
			Arrays.sort(nums);
			int firIndex = 0;
			int secIndex = 1;
			List<Integer> list;
			for (int i = secIndex + 1; i < nums.length; i++) {
				if (nums[firIndex] + nums[secIndex] + nums[i] == 0) {
					list = new ArrayList<>();
					list.add(nums[firIndex]);
					list.add(nums[secIndex]);
					list.add(nums[i]);
					if (!all.contains(list)) {
						all.add(list);
					}
					if (i == nums.length - 1) {
						if (secIndex == nums.length - 2) {
							// 说明什么也没找到，则本轮循环结束
							++firIndex;
							secIndex = firIndex + 1;
							i = secIndex;
						} else {
							i = ++secIndex;
						}
					}
				} else {
					if (i == nums.length - 1) {
						if (secIndex == nums.length - 2) {
							// 说明什么也没找到，则本轮循环结束
							++firIndex;
							secIndex = firIndex + 1;
							i = secIndex;
						} else {
							i = ++secIndex;
						}
					}
				}
			}
		}
		return all;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> all = new ArrayList<>();
		if (nums != null && nums.length > 2) {
			Arrays.sort(nums);
			int firIndex = 0;
			int secIndex = 1;
			List<Integer> list;
			int high = nums.length - 1;
			int low = 0;
			// 找出第1个大于0的数字low
			while (high >= low) {
				int mid = high + low >> 1;
				if (nums[mid] > 0) {
					high = mid - 1;
				} else if (nums[mid] < 0) {
					low = mid + 1;
				}
			}

			for (int i = secIndex + low - 1; i < nums.length; i++) {
				if (nums[firIndex] > 0) {
					break;
				}
				if (nums[firIndex] < 0 && nums[secIndex] < 0 && nums[i] < 0) {
					if (i == nums.length - 1) {
						if (secIndex == nums.length - 2) {
							// 说明什么也没找到，则本轮循环结束
							++firIndex;
							secIndex = firIndex + 1;
							i = secIndex;
						} else {
							i = ++secIndex;
						}
					}
					continue;
				}
				if (nums[firIndex] + nums[secIndex] + nums[i] == 0) {
					list = new ArrayList<>();
					list.add(nums[firIndex]);
					list.add(nums[secIndex]);
					list.add(nums[i]);
					if (!all.contains(list)) {
						all.add(list);
					}

				}
				if (i == nums.length - 1) {
					if (secIndex == nums.length - 2) {
						// 说明什么也没找到，则本轮循环结束
						++firIndex;
						secIndex = firIndex + 1;
						i = secIndex;
					} else {
						i = ++secIndex;
					}
				}
			}
		}
		return all;
	}

	public List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> all = new ArrayList<>();
		if (nums != null && nums.length > 2) {
			Arrays.sort(nums);
			int firIndex = 0;
			int secIndex = 1;
			List<Integer> list;
			// 首个正值
			Integer extra = 0;
			boolean thirNeg = false;
			for (int i = secIndex + 1; i < nums.length; i++) {
				if (nums[firIndex] > 0) {
					break;
				}
				if (nums[i] < 0) {
					thirNeg = true;
					continue;
				}
				if (thirNeg && extra == null) {
					extra = i;
				}
				if (nums[firIndex] + nums[secIndex] + nums[i] == 0) {
					list = new ArrayList<>();
					list.add(nums[firIndex]);
					list.add(nums[secIndex]);
					list.add(nums[i]);
					if (!all.contains(list)) {
						all.add(list);
					}
				}
				if (i == nums.length - 1) {
					if (secIndex == nums.length - 2) {
						// 说明什么也没找到，则本轮循环结束
						++firIndex;
						secIndex = firIndex + 1;
						i = secIndex;
						if (i < extra) {
							i = extra;
						}
					} else {
						++secIndex;
						i = secIndex;
						if (i < extra) {
							i = extra;
						}
					}
				}
			}
		}
		return all;
	}

	public List<List<Integer>> threeSum4(int[] nums) {
		List<List<Integer>> all = new ArrayList<>();
		if (nums != null && nums.length > 2) {
			Arrays.sort(nums);
			int firIndex = 0;
			int secIndex = 1;
			List<Integer> list;
			// 首个正值
			Integer extra = 0;
			boolean thirNeg = false;
			for (int i = secIndex + 1; i < nums.length; i++) {
				if (nums[firIndex] > 0) {
					break;
				}
				if (nums[i] < 0) {
					thirNeg = true;
					continue;
				}
				if (thirNeg && extra == null) {
					extra = i;
				}
				if (nums[firIndex] + nums[secIndex] + nums[i] == 0) {
					list = new ArrayList<>();
					list.add(nums[firIndex]);
					list.add(nums[secIndex]);
					list.add(nums[i]);
					if (!all.contains(list)) {
						all.add(list);
					}
				}
				if (i == nums.length - 1) {
					if (secIndex == nums.length - 2) {
						// 说明什么也没找到，则本轮循环结束
						++firIndex;
						secIndex = firIndex + 1;
						i = secIndex;
						if (i < extra) {
							i = extra;
						}
					} else {
						++secIndex;
						i = secIndex;
						if (i < extra) {
							i = extra;
						}
					}
				}
			}
		}
		return all;
	}

	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSum3(new int[] { -1, 0, 1, 2, -1, -4 }).size());
		Stack stack=new Stack<>();
	}
}
