package com.java.thinking.sort;

public class ErFen {

	private int[] erfen(int attr[]) {
		for (int i = 1; i < attr.length; i++) {
			int tem;
			if (attr[i] < attr[i - 1]) {
				// 默认数组有序，查找出，第一个无序的元素
				tem = attr[i];
			} else {
				continue;
			}
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				// 等号，处理边界值，一直比当前值小，但比最小数大
				int mid = low + high >> 1;
				if (attr[mid] > tem) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for (int j = i; j > low; j--) {
				// low位即tem的位置，需要将它和后续元素均后移
				attr[j] = attr[j - 1];
			}
			attr[low] = tem;
		}
		return attr;
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int low = 0;
		int high = nums.length - 1;
		if (low == high) {
			return nums[0] == target ? 0 : -1;
		}
		while (high > low) {
			int mid = (low + high) >> 1;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ErFen erFen = new ErFen();
		// int[] result = erFen.erfen(new int[] { 10, 8, 7, 7, 2, 9, 3, 0, 1 });
		// for (int v : result) {
		// System.out.println(v);
		// }
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		System.out.println(erFen.search(nums, 9));
		StringBuilder builder;
	}
}
