package com.java.thinking.thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
	private static ThreadPoolManager mInstance;
	private final ThreadPoolExecutor executor;
	private final ExecutorService mReadExecutor;

	private ThreadPoolManager() {
		BlockingQueue<Runnable> queue = new SynchronousQueue<>();
		/*
		 * 
		 */
		executor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.MILLISECONDS, queue);
		/**
		 */
		executor.allowCoreThreadTimeOut(true);
		mReadExecutor = Executors.newSingleThreadExecutor();
	}

	public static ThreadPoolManager getInstance() {
		if (mInstance == null) {
			synchronized (ThreadPoolManager.class) {
				if (mInstance == null)
					mInstance = new ThreadPoolManager();
			}
		}
		return mInstance;
	}

	public void execute(int id, Runnable runnable) {
		try {
			executor.execute(runnable);
		} catch (Exception ex) {
			System.err.println("" + id + (ex == null) + ":" + ex.getLocalizedMessage());
		}
	}

	public void printExecutor() {
		System.err.println("\nActiveCount:" + executor.getActiveCount() + " idleCorePoolSize:" + executor.getPoolSize()
				+ "\n" + " CompletedTaskCount:" + executor.getCompletedTaskCount() + " QueueSize:"
				+ executor.getQueue().size() + "\n" + executor.isShutdown());
	}

	public void executeReadTask(Runnable runnable) {
		mReadExecutor.execute(runnable);
	}

	public boolean submitReadTask(Runnable runnable) throws InterruptedException, ExecutionException {
		Future<Boolean> future = executor.submit(runnable, true);
		return future.get();
	}

	List<Runnable> list;

	public void shutdown() {
		/**
		 */
		list = executor.shutdownNow();
		/**
		 */
		executor.shutdown();
	}

	public void shutdownReadTask() {
		/**
		 */
		mReadExecutor.shutdownNow();
	}

	public boolean isShutdown() {
		return executor.isShutdown();
	}

	public boolean isTerminated() {
		return executor.isTerminated();
	}

	public void restart() {
		int num = executor.prestartAllCoreThreads();
		System.out.println("重启的线程数量：" + num);
		mInstance = null;
		for (Runnable runnable : list) {
			getInstance().execute(10086, runnable);
		}
	}

}