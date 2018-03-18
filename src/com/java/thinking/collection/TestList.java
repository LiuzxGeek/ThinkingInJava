package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		System.out.println(list.toString());
		System.out.println(list.contains("1"));
		String[] urls = { "1", "2", "3", "4" };
		String[] chosenUrl = new String[urls.length - 1];
		int index = 1;
		boolean isTarget = false;
		for (int i = 0; i < urls.length; i++) {
			if (i == index && !isTarget) {
				isTarget = true;
				continue;
			}
			if (isTarget) {
				chosenUrl[i - 1] = urls[i];
			} else {
				chosenUrl[i] = urls[i];
			}
		}
		for (String str : chosenUrl) {
			System.out.println(str);
		}
	}
}
