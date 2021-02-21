package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> ans = new ArrayList<>();
		if (num < 1) {
			ans.add("0:00");
			return ans;
		}
		if (num > 8)
			return ans;
		List<Integer> hours, minites;
		for (int top = num > 5 ? num - 5 : 0; top <= 3 && top <= num; top++) {
			hours = new ArrayList<>();
			minites = new ArrayList<>();
			getCountArr(new int[] { 0, 1, 2, 3 }, 0, hours, top, 0, 11);
			getCountArr(new int[] { 0, 1, 2, 3, 4, 5 }, 0, minites, num - top, 0, 59);
			if (hours.size() > 0 && minites.size() > 0) {
				for (int hour : hours) {
					for (int minite : minites) {
						ans.add(hour + ":" + (minite < 10 ? "0" : "") + minite);
					}
				}
			} else if (hours.size() > 0) {
				for (int hour : hours) {
					ans.add(hour + ":00");
				}
			} else if (minites.size() > 0) {
				for (int minite : minites) {
					ans.add("0:" + (minite < 10 ? "0" : "") + minite);
				}
			}
		}
		return ans;
	}

	private void getCountArr(int[] arr, int index, List<Integer> list, int count, int sum, int max) {
		if (count == 0) {
			if (sum <= max) {
				list.add(sum);
			}
			return;
		}
		for (int i = index; i < arr.length; i++) {
			int value = (int) Math.pow(2, arr[i]);
			sum += value;
			getCountArr(arr, i + 1, list, count - 1, sum, max);
			sum -= value;
		}
	}

	public static void main(String[] args) {
		List<String> ans = (new ReadBinaryWatch()).readBinaryWatch(2);
		for (String str : ans) {
			System.out.println(str);
		}
		char a=' ';
	}
}
