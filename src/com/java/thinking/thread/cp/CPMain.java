package com.java.thinking.thread.cp;

/**
 * @author: liuxian
 * @time: 2017/6/28 9:31
 * @email: liuxian@qccr.com
 * @desc:
 */
public class CPMain {
  public static void execute() {
    Consumer consumer = new Consumer();
    consumer.start();
    Producer producer = new Producer();
    producer.start();
  }
}
