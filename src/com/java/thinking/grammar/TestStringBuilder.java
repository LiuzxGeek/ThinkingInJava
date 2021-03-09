package com.java.thinking.grammar;

/*
*@author:liuxian
*@date:2019年4月25日
*/
public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder(String.valueOf(10));
		builder.append("/");
		builder.append(100);
		System.out.println(builder.toString());
		String result = "四合院数量\tx";
		result = "金屋数量\tx";
		System.out.println(result.substring(0, (result.indexOf("\tx") - 2)));
	}
}
