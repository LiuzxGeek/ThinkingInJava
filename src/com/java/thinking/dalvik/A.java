package com.java.thinking.dalvik;

/*
*@author:liuxian
*@date:2019年6月19日
*/
public class A {
	private static Object mObject = new Object();// or static
	private static long sStartInitlizeTime;
	private static String mClzName;
	private static final long sDelayTime = 2000;

	static {
		sStartInitlizeTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - sStartInitlizeTime > sDelayTime) {
			break;
		}
		System.out.println(mClzName + " static块 " + sDelayTime + "秒延时结束");
	}

	public A(String clzName) {
		// TODO Auto-generated constructor stub
		mClzName = clzName;
	}

	public void print() {
		System.out.println(mClzName + "\t" + mObject.toString());
	}
}
