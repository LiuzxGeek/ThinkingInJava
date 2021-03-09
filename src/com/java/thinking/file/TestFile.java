package com.java.thinking.file;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestFile {
	static volatile ReentrantLock lock = new ReentrantLock();
	static volatile Condition readCon = lock.newCondition();
	static volatile Condition writeCon = lock.newCondition();

	static void testWriteRead() {
		Thread_writeFile thf3 = new Thread_writeFile(lock, writeCon);
		Thread_readFile thf4 = new Thread_readFile(lock, readCon);
		Thread thread1 = new Thread(thf3);
		Thread thread2 = new Thread(thf4);
		thread1.start();
		thread2.start();
	}

	static void testWriteAlong() {
		for (int i = 0; i < 1000; i++) {
			Thread_writeFile thf3 = new Thread_writeFile(lock, writeCon);
			Thread thread1 = new Thread(thf3);
			thread1.start();
		}
	}

	static void testWriteReadAlong() {
		for (int i = 0; i < 1000; i++) {
			Thread_writeFile thf3 = new Thread_writeFile(lock, writeCon);
			thf3.setName(i+"");
			Thread_readFile thf4 = new Thread_readFile(lock, readCon);
			thf4.setName(i+"");
			Thread thread1 = new Thread(thf3);
			Thread thread2 = new Thread(thf4);
			thread1.start();
			thread2.start();
		}
	}

	public static void main(String[] args) {
		testWriteReadAlong();
	}
}
