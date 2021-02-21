package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {

	public static List<Boolean> prefixesDivBy5(int[] A) {
		if (A == null || A.length == 0)
			return null;
		List<Boolean> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			long count = 0;
			for (int j = i; j >= 0; j--) {
				count += A[j] * Math.pow(2, i - j) % 5;
			}
			list.add(count % 5 == 0);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] attr = { 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1,
				1, 0, 1, 0, 0, 0, 1 };
		// List<Boolean> list = prefixesDivBy5(attr);
		// for (Boolean bol : list) {
		// System.out.println(bol);
		// }
		System.out.println(0 << 1);
	}

}
