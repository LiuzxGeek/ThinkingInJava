package com.java.thinking.sort;

public class Quick {

	/**
	 * 时间复杂度O(n^2)--最差情况：n/2*n/2 期望情况：n+2*n/2+4*n/4+……+n*n/n=nLog(n)
	 * 
	 * 先处理单向
	 * 
	 * @param attr
	 * @param left
	 * @param right
	 * @return
	 */
	private int[] quick(int[] attr, int left, int right) {
		if (left >= right) {
			// 说明已经找完
			return attr;
		}
		int tar = attr[left];
		int low = left;
		int high = right;
		while (low < high) {
			while (low < high && attr[high] >= tar) {
				// 从右向左查询，直到小于tar或者越界则停止
				high--;
			}
			// 高低位互换，让小数到前面去
			attr[low] = attr[high];
			while (low < high && attr[low] < tar) {
				// 从左向右查询，直到大于或越界则停止
				low++;
			}
			// 低高位互换，让大数到后面去
			attr[high] = attr[low];
		}
		// 互换后，tar左边都是小数，右边都是大数
		attr[low] = tar;
		// 左快排
		quick(attr, left, low - 1);
		// 右快排
		quick(attr, low + 1, right);
		return attr;
	}

	public static void main(String[] args) {
		Quick quick = new Quick();
		int[] tar = new int[] { 262, 437, 433, 102, 438, 346, 131, 160, 281, 34, 219, 373, 466, 275, 51, 118, 209, 32,
				108, 57, 385, 514, 439, 73, 271, 442, 366, 515, 284, 425, 491, 466, 322, 34, 484, 231, 450, 355, 106,
				279, 496, 312, 96, 461, 446, 422, 143, 98, 444, 461, 142, 234, 416, 45, 271, 344, 446, 364, 216, 16,
				431, 370, 120, 463, 377, 106, 113, 406, 406, 481, 304, 41, 2, 174, 81, 220, 158, 104, 119, 95, 479, 323,
				145, 205, 218, 482, 345, 324, 253, 368, 214, 379, 343, 375, 134, 145, 268, 56, 206 };
		int[] result = quick.quick(tar, 0, tar.length - 1);
		for (int v : result) {
			System.out.println(v);
		}
	}

}
