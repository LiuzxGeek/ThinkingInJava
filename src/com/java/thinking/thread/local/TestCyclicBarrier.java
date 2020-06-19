package com.java.thinking.thread.local;

import java.util.concurrent.CyclicBarrier;

/*
*@author:liuxian
*@date:2020年6月18日
* 先全部分配，结束后，再全部执行
*/
public class TestCyclicBarrier {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("线程组执行结束");
			}
		});
		for (int i = 0; i < 5; i++) {
			new Thread(new readNum(i, cyclicBarrier)).start();
		}
		// CyclicBarrier 可以重复利用，
		// 这个是CountDownLatch做不到的
		// for (int i = 11; i < 16; i++) {
		// new Thread(new readNum(i,cyclicBarrier)).start();
		// }
	}

	static class readNum implements Runnable {
		private int id;
		private CyclicBarrier cyc;

		public readNum(int id, CyclicBarrier cyc) {
			this.id = id;
			this.cyc = cyc;
		}

		@Override
		public void run() {
			synchronized (this) {
				System.out.println("id:" + id);
				try {
					cyc.await();
					System.out.println("线程组任务" + id + "结束，其他任务继续");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
