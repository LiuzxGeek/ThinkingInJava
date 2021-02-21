package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCount {

	public void getRandomArr(int[] arr, int count, List<List<Integer>> res, int index, List<Integer> list) {
		if (arr == null || arr.length < count) {
			return;
		}
		if (count == 0) {
			ArrayList<Integer> tem = new ArrayList<>();
			tem.addAll(list);
			res.add(tem);
		}
		for (int i = index; i < arr.length; i++) {
			Integer value = arr[i];
			list.add(value);
			getRandomArr(arr, count - 1, res, i + 1, list);
			list.remove(value);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		(new RandomNumberCount()).getRandomArr(arr, 4, res, 0, new ArrayList<>());
		int count = 0;
		for (List<Integer> rs : res) {
			for (int num : rs)
				System.out.print(num);
			System.out.println("结束" + ++count);
		}
	}
}
