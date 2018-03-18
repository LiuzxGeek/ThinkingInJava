package com.java.thinking.container;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<>();
		System.out.println(map.get("1") == null);
		int count = 5;
		while (true) {
			if (count == 0)
				break;
			if (count % 2 == 0) {
				count--;
				continue;
			}
			System.out.println(count);
			count--;
		}
	}

	class Student {
	};
}
