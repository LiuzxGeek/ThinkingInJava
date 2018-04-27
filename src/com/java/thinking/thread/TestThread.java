package com.java.thinking.thread;

public class TestThread {
	static volatile int count = 10;

	public static void main(String[] args) {
		final Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (count > 0) {
					System.out.println(count--);
				}
			}
		});
		thread1.start();
		final Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					if (count == 1) {
						thread1.start();
						System.out.println("Game Over");
						break;
					}
				}
			}
		});
		thread2.start();
	}
}
