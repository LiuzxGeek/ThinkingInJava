package com.java.thinking.leetcode.mid;

import java.util.Stack;

public class AddNegabinary {
	public int[] addNegabinary(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 == null)
			return null;
		if (arr1 == null && arr2 != null)
			return arr2;
		if (arr1 != null && arr2 == null)
			return arr1;
		int index1 = arr1.length - 1;
		int index2 = arr2.length - 1;
		int extra = 0;
		Stack<Integer> stack = new Stack<>();
		while (index1 >= 0 || index2 >= 0) {
			extra *= -1;
			int val1 = 0, val2 = 0;
			if (index1 >= 0) {
				val1 = arr1[index1--];
			}
			if (index2 >= 0) {
				val2 = arr2[index2--];
			}
			int sum = val1 + val2 + extra;
			stack.push(Math.abs(sum % 2));
			extra = sum >= 0 ? sum / 2 : -1;
		}
		while (extra != 0) {
			extra *= -1;
			stack.push(Math.abs(extra % 2));
			extra = extra >= 0 ? extra / 2 : -1;
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == 0 && stack.size() > 1) {
				stack.pop();
			} else {
				break;
			}
		}
		int[] target = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			target[stack.size() - 1 - i] = stack.get(i);
		}
		return target;
	}

	public static void main(String[] args) {
		AddNegabinary negabinary = new AddNegabinary();
		int[] arr = negabinary.addNegabinary(new int[] { 1 }, new int[] { 1, 1 });
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
