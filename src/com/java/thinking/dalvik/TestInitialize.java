package com.java.thinking.dalvik;

/*
*@author:liuxian
*@date:2019年6月19日
*/
public class TestInitialize {

	/**
	 * 类加载
	 */
	private static void testClassLoad() {
		System.out.println("---------testClassLoad--------------");
		try {
			Class.forName("A", false, TestInitialize.class.getClassLoader());
		} catch (ClassNotFoundException e) {
			System.out.println("Initalize A is false " + e.getMessage());
		}
		try {
			Class.forName("A", true, TestInitialize.class.getClassLoader());
		} catch (ClassNotFoundException e) {
			System.out.println("Initalize A is true " + e.getMessage());
		}
		Class<?> clzA = StaticA.class;
		System.out.println(clzA.getName());
	}

	/**
	 * 类初始化
	 */
	private static void testClassInitialize() {
		System.out.println("------------testClassInitialize----------");
		StaticA.print();
	}

	public static void main(String[] args) {
		testClassLoad();
		testClassInitialize();
		System.out.println(0x100);
		System.out.println(0x101);
	}
}
