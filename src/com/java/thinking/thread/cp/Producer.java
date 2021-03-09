package com.java.thinking.thread.cp;

/**
 * @author: liuxian
 * @time: 2017/6/28 9:27
 * @email: liuxian@qccr.com
 * @desc:
 */
public class Producer extends CPThread {
  @Override public void run() {
    super.run();
    mLock.lock();
    if (count >= max) {
      try {
        mFullCon.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      mNullCon.signalAll();
    }
    mLock.unlock();
  }
}
