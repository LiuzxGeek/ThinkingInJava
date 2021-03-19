package com.java.thinking.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumDistinct {

	// public static int numDistinct(String s, String t) {
	// int ans = 1;
	// char[] A = s.toCharArray();
	// char[] B = t.toCharArray();
	// // 当前B值
	// char curB = 0;
	// // 当前A、B的数量，A的下标起始位
	// int cac = 0, cbc = 1, ia = 0;
	// for (int b = 0, bLen = B.length; b < bLen; b++) {
	// if (b < bLen - 1) {
	// if (B[b] == B[b + 1]) {
	// cbc++;
	// continue;
	// }
	// }
	// for (int a = ia, aLen = A.length; a < aLen; a++) {
	// if (A[a] == curB) {
	// // 相等后，数量+1
	// cac++;
	// } else if (A[a] == B[b]) {
	// // 相等后，数量+1
	// curB = A[a];
	// cac++;
	// } else {
	// if (cac == 0 && a == aLen - 1) {
	// // 最后也没找到此字符，表示字符不全
	// return 0;
	// }
	// // 计算此字符数的频率-相等则频率为1
	// if (cac > cbc) {
	// while (cac > cbc) {
	// ans = cac--;
	// }
	// cbc = 1;
	// } else if (cac < cbc) {
	// // A上此字符数量，少于B
	// return 0;
	// }
	// // 下个循环，从ia开始
	// ia = a;
	// // 重置当前的数量和数值
	// cac = curB = 0;
	// break;
	// }
	// }
	// }
	// return ans;
	// }

	int ans = 0;

	public int numDistinct(String s, String t) {
		char[] A = s.toCharArray();
		char[] B = t.toCharArray();
		Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		for (int a = 0, aLen = A.length; a < aLen; a++) {
			ArrayList<Integer> list = map.get(A[a]);
			if (list == null) {
				list = new ArrayList<>();
				list.add(a);
				map.put(A[a], list);
			} else {
				list.add(a);
			}
		}
		numDistinct(map, B, 0, -1);
		return ans;
	}

	public void numDistinct(Map<Character, ArrayList<Integer>> map, char[] B, int curB, int curA) {
		ArrayList<Integer> list = map.get(B[curB]);
		if (list == null) {
			// 不存在此字符
			ans = 0;
			return;
		} else {
			int s = 0;
			int e = list.size() - 1;
			while (s <= e) {
				int mid = s + e >> 1;
				int position = list.get(mid);
				// 不可能有相等的
				if (position > curA) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}
			for (int i = s; i < list.size(); i++) {
				curA = list.get(i);
				if (curB < B.length - 1) {
					numDistinct(map, B, curB + 1, curA);
				} else {
					ans += list.size() - i;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		// s = "babgbag";
		// t = "bag";
		s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		t = "bcddceeeebecbc";
		NumDistinct distinct = new NumDistinct();
		System.out.println(distinct.numDistinct(s, t));
	}
}
