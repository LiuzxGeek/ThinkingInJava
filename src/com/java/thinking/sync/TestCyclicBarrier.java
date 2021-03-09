package com.java.thinking.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
*@author:liuxian
*@date:2018年6月6日
*/
/**
 * 用于根据条件，满足后全部执行
 * 
 * @author admin
 *
 */
public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("所有执行完，继续执行下一步");
			}
		});
		for (int i = 0; i < 3; i++) {
			new Worker(barrier).start();
		}
	}

	static class Worker extends Thread {
		CyclicBarrier barrier;

		public Worker(CyclicBarrier barrier) {
			super();
			this.barrier = barrier;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println(getName() + "开始执行");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + "执行结束");
		}
	}
}
