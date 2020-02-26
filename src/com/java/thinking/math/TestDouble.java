package com.java.thinking.math;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

	private static void cc() {
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
		float a = 1 / 2.0f;
		System.out.println(a);
		System.out.println(Math.min(1.0f * 1920 / 667, 1.0f * 1080 / 375));
		System.out.println(Math.max(1.0f * 1920 / 667, 1.0f * 1080 / 375));
		System.out.println(Math.min(1.0f * 2029 / 667, 1.0f * 1080 / 375));
		System.out.println(Math.max(1.0f * 2029 / 667, 1.0f * 1080 / 375));
	}

	public static String getWanFormat(double number) {
        DecimalFormat format = new DecimalFormat("#.00");
		format.setGroupingSize(0);
		format.setRoundingMode(RoundingMode.FLOOR);
		if (number >= 10000) {
			String first = format.format(number / 10000);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 2);
			}
			return (result + "w");
		} else {
			String first = format.format(number);
			String result = first.substring(0, first.length() - 1);
			if (result.endsWith("0")) {
				result = result.substring(0, result.length() - 2);
			}
			return result == null ? "0" : result;
		}
	}

	public static void main(String[] args) {
		System.out.println(getWanFormat(33985d));
		System.out.println(getWanFormat(33985.0123d));
		System.out.println(getWanFormat(339d));
		System.out.println(getWanFormat(339.134d));
		System.out.println(getWanFormat(3390d));
		System.out.println(getWanFormat(3390.134d));
	}
}
