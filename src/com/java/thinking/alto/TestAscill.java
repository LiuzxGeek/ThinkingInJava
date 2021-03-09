package com.java.thinking.alto;

import com.alibaba.fastjson.JSON;

/*
*@author:liuxian
*@date:2019年3月22日
*/
public class TestAscill {
	private static boolean isAscii(char ch) {
		char s = '\u001f';
		char e = '\u007f';
		return ch >= s && ch <= e;
	}

	public static void main(String[] args) {
		System.out.println("中文：" + isAscii('中'));
		System.out.println('\u001f');
		System.out.println('\u007f');
		System.out.println(Integer.toHexString(32));
		Object obj=JSON.parseObject((JSON.toJSONString(null)));
		System.out.println(obj);
	}
}
