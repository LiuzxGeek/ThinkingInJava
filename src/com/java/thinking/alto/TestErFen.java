package com.java.thinking.alto;

public class TestErFen {
	static int array[] = { 1, 2, 3, 4, 5, 6, 7, 87, 8, 43, 2423, 324, 546, 86, 57, 234, 2412, 34534, 546732332, 56, 5,
			435, 75 };

	static int big(int index, int sec, int last) {
		int i = index;
		for (; i < index + sec; i++) {
			if (i >= array.length - 1) {
				return last;
			}
			if (array[i] > last) {
				last = array[i];
			}
		}
		return big(i, sec + i, last);
	}

	static String reverse(String str) {
		if (str.length() <= 1) {
			return str;
		}
		String a = str.substring(0, str.length() / 2);
		String b = str.substring(str.length() / 2, str.length());
		return reverse(b) + reverse(a);
	}

	public static void main(String[] args) {
		System.out.println(big(0, array.length / 4, 0));
		System.out.println(reverse("helloworld"));
	}
}
