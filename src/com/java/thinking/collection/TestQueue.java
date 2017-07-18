package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestQueue {
	private static final BlockingQueue<String> workQueue = new LinkedBlockingQueue<>();

	private static List<String> drainQueue() {
		BlockingQueue<String> q = workQueue;
		ArrayList<String> taskList = new ArrayList<>();
		q.drainTo(taskList);
		if (!q.isEmpty()) {
			for (String r : q.toArray(new String[0])) {
				if (q.remove(r))
					taskList.add(r);
			}
		}
		return taskList;
	}

	public static void main(String[] args) {
		workQueue.offer("1");
		workQueue.offer("2");
		drainQueue();
	}
}
