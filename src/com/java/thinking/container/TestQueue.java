package com.java.thinking.container;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestQueue {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
