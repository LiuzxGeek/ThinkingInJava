package com.java.thinking.constant;

public class TestBoolean {

	public static void main(String[] args) {

		System.out.print("false或:\t");
		System.out.print(false || true && false);
		printBlank();
		System.out.print(false || false && false);// 提示去掉最后一个
		printBlank();
		System.out.print(false || true && true);
		printBlank();
		System.out.println(false || false && false);// 提示去掉最后一个

		System.out.print("true或:\t");
		System.out.print(true || false && false);// 提示去掉最后两个
		printBlank();
		System.out.print(true || true && false);// 提示去掉最后两个
		printBlank();
		System.out.print(true || false && true);// 提示去掉最后两个
		printBlank();
		System.out.print(true || true && true);// 提示去掉最后两个
		System.out.println("\t");

		System.out.print("false与:\t");
		System.out.print(false && true || false);// 提示去掉中间一个
		printBlank();
		System.out.print(false && false || false);// 提示去掉中间一个
		printBlank();
		System.out.print(false && true || true);// 提示去掉中间一个
		printBlank();
		System.out.println(false && false || false);// 提示去掉中间一个

		System.out.print("true与:\t");
		System.out.print(true && false || false);
		printBlank();
		System.out.print(true && true || false);// 提示去掉最后一个
		printBlank();
		System.out.print(true && false || true);
		printBlank();
		System.out.print(true && true || true);// 提示去掉最后一个
	}

	static void printBlank() {
		System.out.print("\t");
	}
}
