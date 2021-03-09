package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
	public List<List<String>> partition(String s) {
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(f[i], true);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
			}
		}
		List<List<String>> ret = new ArrayList<List<String>>();
		dfs(s, 0, new ArrayList<String>(), ret, n, f);
		return ret;
	}

	public void dfs(String s, int i, List<String> ans, List<List<String>> ret, int n, boolean[][] f) {
		if (i == n) {
			ret.add(new ArrayList<String>(ans));
			return;
		}
		for (int j = i; j < n; ++j) {
			if (f[i][j]) {
				ans.add(s.substring(i, j + 1));
				dfs(s, j + 1, ans, ret, n, f);
				ans.remove(ans.size() - 1);
			}
		}
	}

	public List<List<String>> partition2(String s) {
		List<List<String>> ans = new ArrayList();
		int len = s.length();
		// 从第几个，到第几个，是否为回文数
		Boolean[][] attr = new Boolean[len][len];
		for (int i = 0; i < attr.length; i++) {
			Arrays.fill(attr[i], true);
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				attr[i][j] = (s.charAt(i) == s.charAt(j)) && attr[i + 1][j - 1];
			}
		}
		for (Boolean[] i : attr) {
			System.out.println(Arrays.asList(i));
		}
		recall(attr, ans, new ArrayList(), 0, s);
		return ans;
	}

	public List<List<String>> partition3(String s) {
		List<List<String>> ans = new ArrayList();
		int len = s.length();
		// 从第几个，到第几个，是否为回文数
		Boolean[][] attr = new Boolean[len][len];
		for (int i = 0; i < attr.length; i++) {
			Arrays.fill(attr[i], true);
		}
		// 单数肯定回文，直接为true
		for (int i = len - 1; i >= -0; i--) {
			for (int j = i + 1; j < len; j++) {
				// 两个字符相等，而且中间的字符也是回文数
				attr[i][j] = (s.charAt(i) == s.charAt(j)) && attr[i + 1][j - 1];
			}
		}
		for (Boolean[] i : attr) {
			System.out.println(Arrays.asList(i));
		}
		recall(attr, ans, new ArrayList(), 0, s);
		return ans;
	}

	private void recall(Boolean[][] attr, List<List<String>> ans, List<String> tem, int i, String s) {
		if (i == attr.length) {
			ans.add(new ArrayList<String>(tem));
			return;
		}
		for (int j = i; j < attr.length; j++) {
			if (attr[i][j]) {
				tem.add(s.substring(i, j + 1));
				recall(attr, ans, tem, j + 1, s);
				tem.remove(tem.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Partition partition = new Partition();
		String s = "abbab";
		System.out.println(partition.partition(s));
		System.out.println(partition.partition2(s));
		System.out.println(partition.partition3(s));
	}
}
