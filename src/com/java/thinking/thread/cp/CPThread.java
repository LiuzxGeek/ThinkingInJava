package com.java.thinking.thread.cp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liuxian
 * @time: 2017/6/28 9:27
 * @email: liuxian@qccr.com
 * @desc:
 */
public class CPThread extends Thread {
  static String TAG = CPThread.class.getName();

  int min = 0;
  int max = 10;
  int count = 0;

  ReentrantLock mLock = new ReentrantLock();
  Condition mNullCon = mLock.newCondition();
  Condition mFullCon = mLock.newCondition();

}
