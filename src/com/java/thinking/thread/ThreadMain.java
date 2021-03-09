package com.java.thinking.thread;

import java.util.concurrent.ExecutionException;

public class ThreadMain extends Thread {
	static int maxSize = 50;
	static int count = 0;

	public static void main(String[] args) {
		/**
		 */
		ThreadRun threadRun;
		for (int i = 0; i < maxSize; i++) {
			threadRun = new ThreadRun(i);
			// ThreadPoolManager.getInstance().execute(i, threadRun);
			// ThreadPoolManager.getInstance().executeReadTask(threadRun);
			try {
				System.out.println(ThreadPoolManager.getInstance().submitReadTask(threadRun));
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} catch (ExecutionException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		// long time = System.currentTimeMillis();
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
				// ThreadPoolManager.getInstance().execute(i, threadRun);
				// ThreadPoolManager.getInstance().executeReadTask(threadRun);
				// TODO Auto-generated method stub
				// boolean isShutdown =
				// ThreadPoolManager.getInstance().isShutdown();
				// boolean isTerminated =
				// ThreadPoolManager.getInstance().isTerminated();
				// String period = (System.currentTimeMillis() - time) / 1000 +
				// "s";
				// System.out.println(period + " shutdown:" + isShutdown + "
				// terminate:" + isTerminated);
				// ThreadPoolManager.getInstance().printExecutor();
				// if (isShutdown) {
				// cancel();
				// }
//			}
//		}, 10000, 20);
		// ThreadPoolManager.getInstance().shutdown();
		// ThreadPoolManager.getInstance().restart();
		// for (int i = maxSize; i < maxSize + 10; i++) {
		// ThreadRun threadRun = new ThreadRun(i);
		// ThreadPoolManager.getInstance().execute(i, threadRun);
		// }
		// System.out.println("restart");
	}
	// System.out.println("".equals(null));

}
