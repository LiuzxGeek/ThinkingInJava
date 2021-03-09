package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*@author:liuxian
*@date:2018年9月4日
*/
public class TestCollections {
	public static void main(String[] args) {
		List<WelcomeBean> list = new ArrayList<>();
		WelcomeBean bean = new WelcomeBean(1);
		list.add(bean);
		bean = new WelcomeBean(3);
		list.add(bean);
		bean = new WelcomeBean(2);
		list.add(bean);
		Collections.sort(list, new Comparator<WelcomeBean>() {
			@Override
			public int compare(WelcomeBean o1, WelcomeBean o2) {
				// TODO Auto-generated method stub
				return o1.level - o2.level;
			}
		});
		for (WelcomeBean bean2 : list) {
			System.out.println(bean2.level);
		}
	}

	static class WelcomeBean {
		private int level;

		public WelcomeBean(int level) {
			super();
			this.level = level;
		}

	}
}
