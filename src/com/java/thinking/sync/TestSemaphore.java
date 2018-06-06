package com.java.thinking.sync;

import java.util.concurrent.Semaphore;

/*
*@author:liuxian
*@date:2018年6月6日
*/
/**
 * 用于资源占用型任务
 * 
 * @author admin
 *
 */
public class TestSemaphore {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 5; i++) {
			new Worker(semaphore).start();
		}
	}

	static class Worker extends Thread {
		Semaphore semaphore;

		public Worker(Semaphore semaphore) {
			super();
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				semaphore.acquire(2);// 同时开启2个机器，数量不够不停止(改成1则可执行完毕)
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(getName() + "开始工作");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaphore.release();
			System.out.println(getName() + "结束工作");

		}
	}
}
