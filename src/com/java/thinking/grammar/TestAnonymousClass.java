/*
*@author:liuxian
*@date:2018年4月13日
*/
package com.java.thinking.grammar;

public class TestAnonymousClass {
	public static void main(String[] args) {
		Goose goose = new Goose() {

			@Override
			void eat() {
				// TODO Auto-generated method stub
				System.out.println("抽象类goose");
			}
		};
		goose.eat();

		IGoose goose2 = new IGoose() {

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("接口goose");
			}
		};
		goose2.eat();
	}

	static abstract class Goose {
		abstract void eat();
	}

	interface IGoose {
		void eat();
	}
}
