package com.java.thinking.leetcode.sim;

public class BuddyStrings {
	public boolean buddyStrings(String A, String B) {
		if (A == null || B == null) {
			return false;
		}
		if (A.equals("") || B.equals("")) {
			return false;
		}
		if (A.length() != B.length()) {
			return false;
		}
		char aa = ' ', ab = ' ';
		char ba = ' ', bb = ' ';
		boolean finished = false;
		for (int i = 0; i < A.length(); i++) {
			char tem = A.charAt(i);
			if (tem != B.charAt(i)) {
				if (finished) {
					return false;
				} else if (aa == ' ') {
					aa = tem;
					ba = B.charAt(i);
				} else if (ab == ' ') {
					ab = tem;
					bb = B.charAt(i);
					if (aa == bb && ab == ba) {
						finished = true;
					} else if (aa != bb || ab != ba) {
						return false;
					}
				}
			}
		}
		if (A.equals(B)) {
			for (int i = 0; i < A.length(); i++) {
				for (int j = i + 1; j < A.length(); j++) {
					if (A.charAt(i) == A.charAt(j)) {
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println((new BuddyStrings()).buddyStrings("ab", "ab"));
	}
}
