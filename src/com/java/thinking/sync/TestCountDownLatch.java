package com.java.thinking.sync;

import java.util.concurrent.CountDownLatch;

/*
*@author:liuxian
*@date:2018年6月6日
*/
/**
 * 用于计数，在特定条件(递减,无法复用)下执行
 * 
 * @author admin
 *
 */
public class TestCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		new Thread(() -> {
			System.out.println("Thread1 start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}).start();
		new Thread(() -> {
			System.out.println("Thread2 start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}).start();
		try {
			// 等待两次countDown
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error:" + e.getMessage());
		}

		System.out.println("执行12完毕");

	}

}
