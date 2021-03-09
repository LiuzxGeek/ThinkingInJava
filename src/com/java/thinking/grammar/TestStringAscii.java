package com.java.thinking.grammar;

/*
*@author:liuxian
*@date:2019年6月10日
*/
public class TestStringAscii {
	public static String is(String in) {
		// consume an optional byte order mark (BOM) if it exists
		if (in != null && in.startsWith("\ufeff")) {
			in = in.substring(1);
		}
		return in;
	}

	public static void main(String[] args) {
		System.out.println(is(" ss"));
		System.out.println("a\ufeff b");
		System.out.println("a" + "\ufeff" + "b");
	}
}
