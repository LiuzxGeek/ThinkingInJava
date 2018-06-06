package com.java.thinking.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*@author:liuxian
*@date:2018年6月6日
*/
public class TestReentrantLock {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition fullCondition = lock.newCondition();
		Condition emptyCondition = lock.newCondition();

		Producer producer;
		Consumer consumer;
		CountDownLatch downLatch = new CountDownLatch(30);
		List<String> box = new ArrayList<>();
		producer = new Producer(fullCondition, emptyCondition, box, lock, downLatch);
		producer.start();
		consumer = new Consumer(fullCondition, emptyCondition, box, lock, downLatch);
		consumer.start();
		try {
			downLatch.await();
			System.out.println("执行结束");
			producer.stop = true;
			consumer.stop = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Producer extends Thread {
		Condition fullCondition;
		Condition consumerCondition;
		List<String> box;
		ReentrantLock lock;
		CountDownLatch downLatch;
		volatile boolean stop = false;

		public Producer(Condition fullCondition, Condition emptyCondition, List<String> box, ReentrantLock lock,
				CountDownLatch downLatch) {
			super();
			this.fullCondition = fullCondition;
			this.consumerCondition = emptyCondition;
			this.box = box;
			this.lock = lock;
			this.downLatch = downLatch;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!stop) {
				lock.lock();
				if (box.size() == 10) {
					try {
						fullCondition.await();
						consumerCondition.signal();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("蛋糕满了");
				}
				try {
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				box.add("a");
				consumerCondition.signal();
				lock.unlock();
				System.out.println("造了一个,剩下" + box.size());
				downLatch.countDown();
			}
		}
	}

	static class Consumer extends Thread {
		Condition producerCondition;
		Condition consumerCondition;
		List<String> box;
		ReentrantLock lock;
		CountDownLatch downLatch;
		volatile boolean stop = false;

		public Consumer(Condition fullCondition, Condition emptyCondition, List<String> box, ReentrantLock lock,
				CountDownLatch downLatch) {
			super();
			this.producerCondition = fullCondition;
			this.consumerCondition = emptyCondition;
			this.box = box;
			this.lock = lock;
			this.downLatch = downLatch;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!stop) {
				lock.lock();
				if (box.size() == 0) {
					try {
						producerCondition.signal();
						consumerCondition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("蛋糕没了");
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				box.remove(0);
				consumerCondition.signal();
				lock.unlock();
				System.out.println("吃了一个,剩下" + box.size());
				downLatch.countDown();
			}
		}
	}
}
