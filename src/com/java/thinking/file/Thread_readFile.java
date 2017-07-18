package com.java.thinking.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_readFile implements Runnable, ILockInterface {
	ReentrantLock lock;
	Condition condition;
	String name;
	
	public void  setName(String name) {
		this.name=name;
	}
	
	public Thread_readFile(ReentrantLock lock, Condition readCon) {
		// TODO Auto-generated constructor stub
		this.lock = lock;
		condition = readCon;
	}

	public void run() {
		lock.lock();
		System.out.println("Thread_readFile getlock"+name );
		while(true)
		try {
			condition.await();
			break;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread_readFile tryLock " + e.getMessage());
		}
//		FileLock flin = null;
		try {
			Calendar calstart = Calendar.getInstance();
			File file = new File("D:/test.txt");

			// 给该文件加锁
			RandomAccessFile fis = new RandomAccessFile(file, "rw");
			FileChannel fcin = fis.getChannel();
			// while (true) {
			// try {
			// flin = fcin.tryLock();
			// break;
			// } catch (Exception e) {
			// System.out.println("Thread_readFile tryLock " + e.getMessage());
			// }
			// System.out.println("有写线程正在操作该文件，当前线程休眠100毫秒");
			// }
			byte[] buf = new byte[4096];
			StringBuffer sb = new StringBuffer();
			while ((fis.read(buf)) != -1) {
				sb.append(new String(buf, "utf-8"));
				buf = new byte[4096];
			}

			System.out.println(sb.toString());

//			flin.release();
			fcin.close();
			fis.close();
			fis = null;

			Calendar calend = Calendar.getInstance();
			System.out.println("读文件共花了" + (calend.getTimeInMillis() - calstart.getTimeInMillis()) + "秒");
		} catch (Exception e) {
			System.out.println("Thread_readFile run " + e.getMessage());
		} finally {
			try{
			 condition.signal();
			 lock.unlock();
			 }catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Thread_readFile condition " + e.getLocalizedMessage());
			}
		}
	}
}
