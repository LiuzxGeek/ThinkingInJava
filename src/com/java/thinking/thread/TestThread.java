package com.java.thinking.thread;

public class TestThread {
	static String temp = null;

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 1000;
				while (count > 0) {
					System.out.println(count--);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(temp.equals(null));
			}
		}).start();
	}
}
