package com.java.thinking.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_writeFile implements Runnable {
	ReentrantLock lock;
	Condition condition;
	String name;
	
	public void  setName(String name) {
		this.name=name;
	}

	public Thread_writeFile(ReentrantLock lock, Condition writeCon) {
		// TODO Auto-generated constructor stub
		this.lock = lock;
		condition = writeCon;
	}

	public void run() {
		lock.lock();
		System.out.println("Thread_writeFile getlock"+name );
		while(true)
			try {
				condition.await();break;
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				System.out.println("Thread_writeFile tryLock" + e1.getMessage());
			}
		// TODO Auto-generated catch block
		Calendar calstart = Calendar.getInstance();
		File file = new File("D:/test.txt");
//		FileLock flout = null;
		try {
			if (!file.exists())
				file.createNewFile();

			// 对该文件加锁
			RandomAccessFile out = new RandomAccessFile(file, "rw");
			FileChannel fcout = out.getChannel();
//			while (true) {
//				try {
//					flout = fcout.tryLock();
//					break;
//				} catch (Exception e) {
//					System.out.println("Thread_writeFile tryLock" + e.getMessage());
//				}
//				System.out.println("有读线程正在操作该文件，当前线程休眠100毫秒");
//			}
			for (int i = 1; i <= 1000; i++) {
				StringBuffer sb = new StringBuffer();
				try {
					if (i % 100 == 0) {
						File newFile = new File("100.txt");
						file.renameTo(newFile);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				sb.append("这是写入的第" + i + "行，应该没啥错哈 \n");
				out.write(sb.toString().getBytes("utf-8"));
			}

//			flout.release();
			fcout.close();
			out.close();
			out = null;
		} catch (IOException e) {
			System.out.println("Thread_writeFile run" + e.getMessage());
		} finally {
			try {
				condition.signalAll();
				lock.unlock();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Thread_writeFile signal" + e2.getLocalizedMessage());
			}
		}
		Calendar calend = Calendar.getInstance();
		System.out.println("写文件共花了" + (calend.getTimeInMillis() - calstart.getTimeInMillis()) + "秒");
	}
}
