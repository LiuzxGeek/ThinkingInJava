package com.java.thinking.encode;

/*
*@author:liuxian
*@date:2020年3月23日
*/
public class TestEncode {
	public static void main(String[] args) {
		String result="https://m.facebook.com/story.php?story_fbid=2429177300517323&id=100002752294630&sfnsn=mo";
		System.out.println(result.split("&id=")[1].split("&")[0]);
	}
}
