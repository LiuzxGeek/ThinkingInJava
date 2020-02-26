package com.java.thinking.dalvik;

/*
*@author:liuxian
*@date:2019年6月19日
*/
public class StaticA {

	public static final Object sObject = new Object();
	private static long sStartInitlizeTime;
	private static volatile String sClzName;
	private static final long sDelayTime = 2000;

	public StaticA(String clzName) {
		// TODO Auto-generated constructor stub
		sClzName = clzName;
	}

	static {
		sStartInitlizeTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - sStartInitlizeTime > sDelayTime) {
			break;
		}
		System.out.println(sClzName + " static块 " + sDelayTime + "毫秒延时结束");
	}

	public static void print() {
		System.out.println(sClzName + " " + sObject.toString());
	}
}
