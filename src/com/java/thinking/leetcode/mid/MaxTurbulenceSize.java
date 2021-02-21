package com.java.thinking.leetcode.mid;

public class MaxTurbulenceSize {
	public static int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
		int ret = 1;
		int left = 0, right = 0;

		while (right < n - 1) {
			if (left == right) {
				if (arr[left] == arr[left + 1]) {
					left++;
				}
				right++;
			} else {
				if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
					right++;
				} else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
					right++;
				} else {
					left = right;
				}
			}
			ret = Math.max(ret, right - left + 1);
		}
		return ret;
	}

	public static int maxTurbulenceSize2(int[] arr) {
		int maxCount = 1;
		int len = arr.length;
		int left = 0, right = 0;
		while (right < len - 1) {
			if (right == left) {
				if (arr[left] == arr[left + 1]) {
					left++;
				}
				right++;
			} else {
				if (arr[right] > arr[right + 1] && arr[right] > arr[right - 1]) {
					right++;
				} else if (arr[right] < arr[right + 1] && arr[right] < arr[right - 1]) {
					right++;
				} else {
					left = right;
				}
			}
			maxCount = Math.max(maxCount, right - left + 1);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 8, 12, 16 };
		System.out.println(maxTurbulenceSize2(arr));
	}
}
