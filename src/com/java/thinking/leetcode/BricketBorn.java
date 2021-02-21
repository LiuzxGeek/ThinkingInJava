package com.java.thinking.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BricketBorn {

	private static List<String> generateBricket(int num) {
		List<String> list = new LinkedList();

		return list;
	}

	private static String getResult(String temp, int index) {
		return temp.substring(0, index) + ")" + temp.substring(index, index + 1);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList();
		if (n < 1) {
			return res;
		}
		String str = "";
		dfs(str, res, n, n);
		return res;
	}

	// left代表左括号目前剩余分配数，right代表右括号剩余分配数
	public static void dfs(String str, List<String> res, int left, int right) {
		// 当左右括号都分配完，则将组合加入res
		if (left == 0 && right == 0) {
			res.add(str);
			return;
		}
		// 先加“（”,当left还有剩余时就加入“（”
		if (left > 0) {
			System.out.println("left:" + left + " right" + right + " str:" + str);
			// 加入“（”后递归调用，实现DFS
			dfs(str + "(", res, left - 1, right);
		}
		// 只有当“（”添加的数量比“）”多时才能添加“）”
		if (left < right) {
			System.out.println("left:" + left + " right" + right + " str:" + str);
			// DFS
			dfs(str + ")", res, left, right - 1);
		}
	}

	public static void main(String[] args) {
		// System.out.println("(((".substring(0, 2));
		// System.out.println("(((".substring(1));
//		System.out.println(generateParenthesis(3));
		System.out.println(Integer.valueOf("001"));
	}
}
