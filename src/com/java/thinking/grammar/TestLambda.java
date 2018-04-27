package com.java.thinking.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLambda {
	private static List<String> list = new ArrayList<>();
	private static Map<String, Integer> map = new HashMap<>();
	static {
		list.add("a");
		list.add("b");
		map.put("a", 1);
		map.put("b", 2);
	}

	public static void main(String[] args) {
		new Thread(() -> System.out.println("hello Lambda")).start();
		list.forEach(str -> System.out.println(str));
		list.stream().filter(s -> s.contains("b")).forEach(str -> System.out.println(str));
		map.forEach((key, vale) -> System.out.println(map.get(key)));
		int b = new Alphgo().add(1, 2);
	}

	static class Alphgo {
		public int add(int a, int b) {
			return a + b;
		}
	}
}
