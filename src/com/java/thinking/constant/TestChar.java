package com.java.thinking.constant;

/*
*@author:liuxian
*@date:2018年10月19日
*/
public class TestChar {

	private static void testEmptyChar() {
		String str = "https://live-uat.huachat.com/huajianApp/activity/page/openMemberGuide.html ?anchorId=1090883906&userId=1090883961&roomId=60824101";
		System.out.println(str);
		System.out.println(str.trim());
	}

	public static void main(String[] args) {
		char at = 'A' - 1;
		for (int i = 0; i < 26; i++) {
			at += 1;
			char bt = 'A' - 1;
			for (int j = 0; j < 26; j++) {
				bt += 1;
				System.out.println(at + "/" + bt);
			}
		}
		System.out.println(100 * 49182227l / 49182227l);
		testEmptyChar();
		char a = 0x89c6;
		System.out.println(a);
		char s='\u001f';
		char e='\u007f';
		System.out.println(s);
		System.out.println(e);
	}
}
