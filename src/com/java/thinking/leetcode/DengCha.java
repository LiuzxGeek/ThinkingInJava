package com.java.thinking.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*@author:liuxian
*@date:2020年7月8日
*/
public class DengCha {
	public static void main(String[] args) {
		canMakeArithmeticProgression(new int[] { 1, 3, 5, -1 });
	}

	public static boolean canMakeArithmeticProgression(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return false;
		}
		Integer[] temp = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		List<Integer> list = Arrays.asList(temp);
		Collections.sort(list);
		Integer[] newArr = new Integer[arr.length];
		list.toArray(newArr);
		int differ = newArr[1] - newArr[0];
		for (int i = 2; i < newArr.length; i++) {
			if (newArr[i] - newArr[i - 1] != differ) {
				return false;
			}
		}
		return true;
	}
}
