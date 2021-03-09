package com.java.thinking.oral;

public class TestClosePackage {
	private int cakes = 15;

	public Action action() {
		return new Action() {

			@Override
			public void eat() {
				// TODO Auto-generated method stub
				if (--cakes == 0) {//cakes作为内部引用变量，如果在外部定义，内部初始化则需要加final，保持变量同步
					System.out.println("吃完了");
					return;
				}
				System.out.println("吃一个");
			}
		};
	}

	void left() {
		System.out.println("剩下：" + cakes);
	}

	interface Action {
		void eat();
	}

	public static void main(String[] args) {
		TestClosePackage closePackage = new TestClosePackage();
		Action action = closePackage.action();
		action.eat();
		closePackage.left();
	}
}
