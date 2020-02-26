package com.java.thinking.dalvik;

/*
*@author:liuxian
*@date:2019年6月19日
*/
public class TestAInitialize {
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
	}
}
