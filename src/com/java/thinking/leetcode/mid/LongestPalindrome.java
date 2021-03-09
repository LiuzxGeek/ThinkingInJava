package com.java.thinking.leetcode.mid;

public class LongestPalindrome {
	String ans = "";

	public String longestPalindrome(String s) {
		char[] attr = s.toCharArray();
		int len = attr.length;
		String ans = String.valueOf(attr[0]);
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (isPalindrome(attr, i, j)) {
					String tem = s.substring(i, j + 1);
					if (tem.length() > ans.length()) {
						ans = tem;
					}
				}
			}
		}
		return ans;
	}

	public boolean isPalindrome(char[] attr, int left, int right) {
		while (left < right) {
			if (attr[left] == attr[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LongestPalindrome palindrome = new LongestPalindrome();
		System.out.println(palindrome.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
	}
}
