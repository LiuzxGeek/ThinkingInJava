package com.java.thinking.data;

import java.util.ArrayList;
import java.util.List;

/*
*@author:liuxian
*@date:2019年4月3日
*/
public class TestForEach {
	private static String name = "john";
	private static String activity = getName() + " is playing";

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		TestForEach.name = name;
	}

	public static String getActivity() {
		return getName() + " is playing";
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		for (int i = 0; i < list.size(); i++) {
			if (i == 2) {
				list.remove(i);
				i--;
			}
			System.out.println(list.get(i));
		}
		System.out.println(getActivity());
		setName("jim");
	}
}
