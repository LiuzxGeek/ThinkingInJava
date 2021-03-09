package com.java.thinking.thread;

import java.util.concurrent.CountDownLatch;

/*
*@author:liuxian
*@date:2019年7月17日
*/
public class MyThreadLocalStringDemo {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	private static MyThreadLocalStringDemo demo;

	private String getString() {
		return threadLocal.get();
	}

	private void setString(String string) {
		threadLocal.set(string);
	}

	public static void main(String[] args) {
		demo = new MyThreadLocalStringDemo();
//		testNoneLocal();
		testThreadLocal();
		System.out.println("------------------------");
	}

	private static void testNoneLocal() {
		int threads = 9;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(() -> {
				demo.setString(Thread.currentThread().getName());
				System.out.println(demo.getString());
				countDownLatch.countDown();
			}, "thread - " + i);
			thread.start();
		}
	}

	private static void testThreadLocal() {
		int threads = 9;
		CountDownLatch countDownLatch = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(() -> {
				demo.setString(Thread.currentThread().getName());
				System.out.println(demo.getString());
				countDownLatch.countDown();
			}, "thread - " + i);
			thread.start();
		}
	}
}