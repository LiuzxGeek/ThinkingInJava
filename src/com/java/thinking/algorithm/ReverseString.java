package com.java.thinking.algorithm;

/*
*@author:liuxian
*@date:2019年12月26日
*/
public class ReverseString {

	public static String reverse2(String s) {// 2分法+异或算法
		char[] str = s.toCharArray();
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			System.out.println(begin + "轮:" + str[begin] + " " + str[end]);
			str[begin] = (char) (str[begin] ^ str[end]);
			System.out.println(str[begin] + " " + str[end]);
			str[end] = (char) (str[begin] ^ str[end]);
			System.out.println(str[begin] + " " + str[end]);
			str[begin] = (char) (str[end] ^ str[begin]);
			System.out.println(str[begin]);
			begin++;
			end--;
		}
		return new String(str);
	}

	public static String reverse4(String s) {
		if (s.length() == 1) {
			return s;
		}
		String left = s.substring(0, s.length() / 2);
		String right = s.substring(s.length() / 2, s.length());
		return reverse4(right) + reverse4(left);
	}

	public static String reverse5(String s) {// 傳統从后往前加
		int length = s.length();
		String reverse = "";
		for (int i = 0; i < length; i++)
			reverse = s.charAt(i) + reverse;
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(new StringBuffer("1234").reverse());
		System.out.println(reverse4("12345"));
		System.out.println(reverse5("12345"));
	}
}
