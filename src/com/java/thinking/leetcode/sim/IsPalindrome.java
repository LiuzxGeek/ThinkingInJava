package com.java.thinking.leetcode.sim;

import java.util.regex.Pattern;

public class IsPalindrome {
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll(" ", "");
		int dMax = 'z' - 'a';
		int nMax = '9' - '0';
		int start = 0, end = s.length() - 1;
		while (start < end) {
			char sc = s.charAt(start);
			char ec = s.charAt(end);
			if ((sc - '0' >= 0 && sc - '0' <= nMax) || (sc - 'a' >= 0 && sc - 'a' <= dMax)) {
				if ((ec - '0' >= 0 && ec - '0' <= nMax) || (ec - 'a' >= 0 && ec - 'a' <= dMax)) {
					if (sc != ec) {
						return false;
					} else {
						start++;
						end--;
					}
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		s = s.toLowerCase().replaceAll(" ", "");
		int start = 0, end = s.length() - 1;
		while (start < end) {
			char sc = s.charAt(start);
			char ec = s.charAt(end);
			if (Character.isLetterOrDigit(sc)) {
				if (Character.isLetterOrDigit(ec)) {
					if (sc != ec) {
						return false;
					} else {
						start++;
						end--;
					}
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
		return true;
	}

	public static boolean isPalindrome3(String s) {
		s = s.toLowerCase().replaceAll(" ", "");
		int start = 0, end = s.length() - 1;
		String regex = "[0-9a-z]";
		Pattern pattern = Pattern.compile(regex);
		while (start < end) {
			char sc = s.charAt(start);
			char ec = s.charAt(end);
			if (pattern.matcher(String.valueOf(sc)).find()) {
				if (pattern.matcher(String.valueOf(ec)).find()) {
					if (sc != ec) {
						return false;
					} else {
						start++;
						end--;
					}
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		s = "race a car";
		System.out.println(isPalindrome3(s));
	}
}
