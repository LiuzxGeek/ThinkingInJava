package com.java.thinking.leetcode.sim;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		String left = num1;
		String right = num2;
		if (num1.length() < num2.length()) {
			left = num2;
			right = num1;
		}
		String result = "";
		char[] lc = left.toCharArray();
		char[] rc = right.toCharArray();
		int extra = 0;
		int count = 0;
		while (count < lc.length) {
			int r = lc[lc.length - 1 - count] - '0';
			if (count < rc.length) {
				r += rc[rc.length - 1 - count] - '0';
			}
			r += extra;
			count++;
			extra = r / 10;
			result = r % 10 + result;
		}
		if (extra > 0) {
			result = extra + result;
		}
		return result;
	}

	public String addStrings2(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		int extra = 0, i = num1.length() - 1, j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				extra += num1.charAt(i--) - '0';
			}
			if (j >= 0) {
				extra += num2.charAt(j--) - '0';
			}
			builder.append(extra % 10);
			extra /= 10;
		}
		if (extra > 0) {
			builder.append(extra);
		}
		return builder.reverse().toString();
	}

	public String addStrings3(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		int extra = 0, i = num1.length() - 1, j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				int start = i;
				while (start > 9) {
					start /= 2;
				}
				extra += Integer.valueOf(String.valueOf(num1.substring(i - 2, i)));
				i -= start;
			}
			if (j >= 0) {
				extra += Integer.valueOf(String.valueOf(num2.substring(j - 2, j)));
				j -= 2;
			}
			builder.append(extra % 10);
			extra /= 10;
		}
		if (extra > 0) {
			builder.append(extra);
		}
		return builder.reverse().toString();
	}

	public int getMax(int count) {
		while (count > Integer.MAX_VALUE / 10) {
			count /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		AddStrings strings = new AddStrings();
		System.out.println(strings.addStrings2("99", "99"));
		int r = '9' - '0';
		System.out.println(r);
		System.out.println(Math.addExact(1, 20));
		System.out.println(Integer.sum(1, 2));
	}
}
