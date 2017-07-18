package com.java.thinking.oral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		System.out.println(list.remove("1"));
		list.add("1");
		list.add("2");
		// for (String temp : list) {
		// if ("2".equals(temp))
		// list.remove(temp);//删除方法修改了循环方法里的expectModeCount
		// }
//		Iterator<String> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			if ("2".equals(iterator.next()))
//				iterator.remove();
//		}
//		for (String temp : list) {
//			System.out.println(temp);
//		}
//		LongAdder adder = new LongAdder();
//		adder.add(5);
//		adder.decrement();
//		System.out.println(adder.floatValue());
//		CountDownLatch countDownLatch = new CountDownLatch(2);
//		try {
//			countDownLatch.await();
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			// TODO: handle finally clause
//			countDownLatch.countDown();
//		}
		List<String> bList = new ArrayList<>();
		bList.add("3");
		bList.add("2");
		list.removeAll(bList);
		for (String str : list)
			System.out.println(str);
	}
}
