package com.java.thinking.math;

import java.util.regex.Pattern;

/*
*@author:liuxian
*@date:2018年5月19日
*/
public class TestDouble {
	public static String get1BitData(double number) {
		String first = String.valueOf(number);
		String second = first.substring(first.indexOf("."));
		if (second.length() > 1 && !second.endsWith("0")) {
			return String.valueOf(number);
		}
		return String.valueOf((int) number);
	}

	public static String get1BitStr(String first) {
		String[] attr = first.split(".");
		if (attr.length > 1) {
			String arr = first.split(".")[1];
			if (arr.length() > 1) {
				return String.valueOf(first);
			}
		}
		return "1";
	}

	public static String[] split(String regex, int limit) {
		/*
		 * fastpath if the regex is a (1)one-char String and this character is not one
		 * of the RegEx's meta characters ".$|()[{^?*+\\", or (2)two-char String and the
		 * first char is the backslash and the second is not the ascii digit or ascii
		 * letter.
		 */
		char ch = 0;
		if (((regex.length() == 1 && ".$|()[{^?*+\\".indexOf(ch = regex.charAt(0)) == -1)
				|| (regex.length() == 2 && regex.charAt(0) == '\\' && (((ch = regex.charAt(1)) - '0') | ('9' - ch)) < 0
						&& ((ch - 'a') | ('z' - ch)) < 0 && ((ch - 'A') | ('Z' - ch)) < 0))
				&& (ch < Character.MIN_HIGH_SURROGATE || ch > Character.MAX_LOW_SURROGATE)) {
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(get1BitData(1));
		System.out.println(get1BitData(1.1d));
		System.out.println(get1BitData(1.10d));
		System.out.println(get1BitData(1.01d));
		System.out.println(get1BitData(1.010d));
		System.out.println(get1BitData(1.001d));
		System.out.println(get1BitStr("1.001"));
		System.out.println(String.valueOf(1.10));
		split("1.1", 0);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (i > Character.MIN_HIGH_SURROGATE) {
				System.out.println(i);
				break;
			}
		}
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (i > Character.MAX_LOW_SURROGATE) {
				System.out.println(i);
				break;
			}
		}
		String[] attr = Pattern.compile(".").split("1.23", 0);
		for (String str : attr) {
			System.out.println(str);
		}
		boolean flag = ".$|()[{^?*+\\".indexOf(".".charAt(0)) == -1;
		System.out.println(".$|()[{^?*+\\".indexOf(".".charAt(0)));
		System.out.println(flag);
	}
}
