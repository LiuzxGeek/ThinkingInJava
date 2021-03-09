package com.java.thinking.grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*@author:liuxian
*@date:2019年5月15日
*/
public class TestVolatile {
	volatile static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Long.valueOf("23b"));
		for (int i = 0; i < 100; i++) {
			final int s = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(20);
						synchronized (list) {
							list.add(getHe(s, 100));							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(12000);
					Collections.sort(list, new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							if (o1 == null) {
								o1 = new Integer(0);
							}
							if (o2 == null) {
								o2 = new Integer(0);
							}
							if (o1.intValue() > o2.intValue()) {
								return 1;
							} else if (o1.intValue() < o2.intValue()) {
								return -1;
							} else {
								return 0;
							}
						};
					});
					if (list != null) {
						for (int i : list) {
							System.out.println(i);
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();
	}

	private static int getHe(int i, int j) {
		return i + j;
	}

}
