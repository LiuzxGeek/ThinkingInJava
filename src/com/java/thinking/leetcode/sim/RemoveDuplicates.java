package com.java.thinking.leetcode.sim;

public class RemoveDuplicates {
	public static String removeDuplicates(String S) {
		int len = S.length();
		char[] attr = S.toCharArray();
		for (int i = 0; i < len - 1; i++) {
			if (attr[i] == attr[i + 1]) {
				StringBuilder builder = new StringBuilder();
				if (i > 0) {
					builder.append(S.substring(0, i));
				}
				if (i + 2 < len) {
					builder.append(S.substring(i + 2));
				}
				return removeDuplicates(builder.toString());
			}
		}
		return S;
	}

	public static String removeDuplicates2(String S) {
		int len = S.length();
		for (int i = 0; i < len - 1; i++) {
			if (S.charAt(i) == S.charAt(i + 1)) {
				String str1 = "";
				String str2 = "";
				if (i > 0) {
					str1 = S.substring(0, i);
				}
				if (i + 2 < len) {
					str2 = S.substring(i + 2);
				}
				S = str1 + str2;
				len = S.length();
				i -= i > 0 ? 2 : 1;
			}
		}
		return S;
	}

	public static void main(String[] args) {
		String S = "azxxzy";
		S = "aaaaaaaa";
		System.out.println(removeDuplicates2(S));
		System.out.println(':'-'0');
	}
}
