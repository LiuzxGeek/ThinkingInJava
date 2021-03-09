package com.java.thinking.dalvik;

import com.java.thinking.constant.TestBoolean;

/*
*@author:liuxian
*@date:2019年6月19日
*/
public class TestAInitialize {
	private static TestBoolean testBoolean = null;
	private static String testString;

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			String name = "A" + i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					new A(name).print();
				}
			}).start();
		}
		System.out.println(testBoolean instanceof TestBoolean);
		System.out.println(testString instanceof String);
	}
}
