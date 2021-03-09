package com.java.thinking.thread;

import java.util.Random;

public class ThreadRun implements Runnable {
	long currentTime;
	int id;
	int ri;
	Object obj;

	volatile long lastTime = 1000;

	public ThreadRun(int id) {
		// TODO Auto-generated constructor stub
		currentTime = System.currentTimeMillis();
		this.id = id;
		ri = new Random().nextInt(30);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.err.println("线程" + id + "\n");
		// while (true) {
		try {
			Thread.sleep(10);//
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (id == 5) {
			System.out.println(obj.toString());
		}
		// if (System.currentTimeMillis() - currentTime > (ThreadMain.maxSize -
		// id) * 1000) {
		// System.err.println(name + (System.currentTimeMillis() - currentTime)
		// + "ms");
		// }
		// if (System.currentTimeMillis() - lastTime > 1000) {
		// System.out.println(name + (System.currentTimeMillis() - currentTime)
		// + "ms");
		// lastTime = System.currentTimeMillis();
		// ThreadPoolManager.getInstance().printExecutor();
		// }
	}
	// }
}
