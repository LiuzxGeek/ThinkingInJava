package com.java.thinking.oral;

import java.io.UnsupportedEncodingException;

/*
*@author:liuxian
*@date:2019年5月30日
*/
public class TestEncode {
	public static void main(String[] args) {
		String origin = "å¥³å£«";
		try {
			String utf8Str = new String(origin.getBytes(), "utf-8");
			System.out.println(utf8Str);
			String engUtf8Str = new String(origin.getBytes(), "latin1");
			System.out.println(engUtf8Str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
