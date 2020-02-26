package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.List;

/*
*@author:liuxian
*@date:2019年8月29日
*/
public class TestArray {
	public static void main(String[] args) {
		List<Integer> mList = new ArrayList<>();
		mList.add(1);
		 mList.add(2);
		 mList.add(3);
		 mList.add(4);
		 mList.add(5);
		 mList.add(6);
		 mList.add(7);
		List<List<Integer>> comboList = new ArrayList<>();
		int count = mList.size() / 6;
		List<Integer> childList;
		for (int i = 0; i < count; i++) {
			childList = new ArrayList<>();
			childList.addAll(mList.subList(i * 6, (i + 1) * 6));
			comboList.add(childList);
		}
		if (mList.size() % 6 > 0) {
			childList = new ArrayList<>();
			childList.addAll(mList.subList(count * 6, mList.size()));
			comboList.add(childList);
		}
		for (List<Integer> list : comboList) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
