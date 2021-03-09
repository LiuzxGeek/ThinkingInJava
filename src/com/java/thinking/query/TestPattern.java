package com.java.thinking.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@author:liuxian
*@date:2020年3月25日
*/
public class TestPattern {
	public static void main(String[] args) {
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher("1feed_story_ring100002752294630");
		System.out.println(m.replaceAll("").trim());
	}
}
