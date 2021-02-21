package com.java.thinking.leetcode.contest;

public class MaximumTime {
	public String maximumTime(String time) {
		String[] arr = time.split(":");
		StringBuilder builder = new StringBuilder();
		if (arr[0].charAt(0) == '?' && arr[0].charAt(1) == '?') {
			builder.append("23:");
		} else if (arr[0].charAt(0) == '?') {
			int tem = arr[0].charAt(1) - '0';
			if (tem > 3) {
				builder.append("1" + tem + ":");
			} else {
				builder.append("2" + tem + ":");
			}
		} else if (arr[0].charAt(1) == '?') {
			int tem = arr[0].charAt(0) - '0';
			if (tem == 2) {
				builder.append(tem + "3:");
			} else {
				builder.append(tem + "9:");
			}
		} else {
			builder.append(arr[0] + ":");
		}

		if (arr[1].charAt(0) == '?' && arr[1].charAt(1) == '?') {
			builder.append("59");
		} else if (arr[1].charAt(0) == '?') {
			builder.append("5" + arr[1].substring(1));
		} else if (arr[1].charAt(1) == '?') {
			builder.append(arr[1].substring(0, 1) + "9");
		} else {
			builder.append(arr[1]);
		}
		return builder.toString();

	}

	public static void main(String[] args) {
		System.out.println('a');
		System.out.println('a' + 1);
	}
}
