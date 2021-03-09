package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.List;

public class ListChars {
	/**
	 * @param chars
	 *            总的字符序列（数组）
	 * @param n
	 *            要取出的字符的个数
	 */
	public static void doit(char[] chars, int n) {
		if (n <= 0 || chars == null) {
			return;
		}
		List<Character> charList = new ArrayList<>();
		// 通过这一步初始化序列的长度
		for (int i = 0; i < n; i++) {
			charList.add('#');
		}
		listAll(charList, chars, n, 0);
	}

	/**
	 * 从m个元素中任取n个并对结果进行全排列
	 * 
	 * @param list
	 *            用于承载可能的排列情况的List
	 * @param chars
	 *            总的字符数组，长度为m
	 * @param n
	 *            从中取得字符个数
	 */
	public static void listAll(List<Character> list, char[] chars, int n, int index) {
		if (n == 0) {
			// 这里偷懒，直接打印了....
			System.out.println(list);
			return;
		}
		for (int i = index; i < chars.length; i++) {
			// 暴力尝试
			if (!list.contains(chars[i])) {
				// 若List中不包含这一位元素
				list.set(list.size() - n, chars[i]);
				// 将当前元素加入
			} else {
				// 否则跳到下一位
				continue;
			}
			listAll(list, chars, n - 1, i + 1);
			// 下一位
			list.set(list.size() - n, '#');
			// 还原
		}
	}

	public static void main(String[] args) {
		// 以字符数组承载总的字符集合
		char[] chars = { 'a', 'b', 'c', 'd' };
		ListChars.doit(chars, 2);
	}
}
