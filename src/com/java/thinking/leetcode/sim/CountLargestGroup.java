package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup {
	public static int countLargestGroup(int n) {
		int[] arr = new int[n / 2];
		for (int i = 1; i <= n; i++) {
			int num = 0;
			int tem = i;
			while (tem > 0) {
				num += tem % 10;
				tem /= 10;
			}
			arr[num - 1] += 1;
		}
		Arrays.sort(arr);
		int ans = 1;
		int target = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (target == arr[i]) {
				ans++;
			} else {
				break;
			}
		}
		return ans;
	}

	public int countLargestGroup2(int n) {
		// 将字符相同的数据，用map绑在一起
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int num = 0;
			while (i > 0) {
				num += i % 10;
				i /= 10;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// 排序，将数量多的排在前面
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				// 降序
				return o2.getValue() - o1.getValue();
			}
		});
		// 查找最多数据的数量
		int ans = 0;
		Integer target = null;
		for (Map.Entry<Integer, Integer> entry : list) {
			if (target == null) {
				target = entry.getValue();
			} else if (target != entry.getValue()) {
				break;
			}
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(countLargestGroup(33));
	}
}
