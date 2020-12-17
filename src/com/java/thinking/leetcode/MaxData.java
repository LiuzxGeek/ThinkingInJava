package com.java.thinking.leetcode;

public class MaxData {
	/*
	 * 假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5; 组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 +
	 * 1五种情况,就是从此五种情况取出组合最大的一种; Math.max(0, k - n)表示若数组二的元素个数 >=
	 * k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
	 */
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		int[] res = new int[k];
		if (m + n >= k) {
			// i为选择数组内元素的个数
			for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
				if (nums2.length < i || nums1.length < k - i) {
					continue;
				}
				// 前后两个数组取出的所有数据量等于k
				int[] arr = merge(maxArr(nums2, i), maxArr(nums1, k - i), k);
				if (gt(arr, 0, res, 0)) {
					// 不断进行比较， 前者大，则用前者
					res = arr;
				}
			}
		}
		return res;
	}

	/*
	 * 假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3]; n - i :
	 * 当前数组中,当前下标到结尾还有多少个元素; j : 当前数组中i之前有多少个数加入到最大组合中; n - i + j > k <=> n - i - 1
	 * + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--, n - i(数组剩余元素) -
	 * 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k; if j < k : 先将最大组合填满再进行比较替换操作
	 */
	private static int[] maxArr(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[k];
		for (int i = 0, j = 0; i < n; i++) {
			// j为数组目前存储大小，curCount指目前数组剩余可存的数据量+当前已存储的数据量
			int curCount = n - i + j;
			// 此循环的意义在于，在curCount允许的情况下，将最前面小数字遍历并替换掉
			while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) {
				j--;
			}
			if (j < k) {
				// 数据量大，而需求少-不退出的原因，是要遍历后面是否有更大数据
				res[j++] = nums[i];
			}
		}
		return res;
	}

	/*
	 * 假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
	 */
	private static int[] merge(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; r++) {
			// 带着下标，计算两个数组，获得较大值
			res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		}
		return res;
	}

	/*
	 * 比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
	 */
	private static boolean gt(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			// 算出两个数组不等的时候
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
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
