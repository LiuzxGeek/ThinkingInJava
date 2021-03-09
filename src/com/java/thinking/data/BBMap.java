package com.java.thinking.data;

import java.util.HashMap;
import java.util.Hashtable;

public class BBMap extends ABMap {
	public static void main(String[] args) {
		System.out.println(1 << 11);
		System.out.println(Integer.MAX_VALUE);
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "1");
		System.out.println(map.get(1));
		map.put(1, "2");
		System.out.println(map.containsValue("1"));
		//map.remove(1);
		System.out.println(map.get(1));
		map.put(null, "3");
		System.out.println(map.size());
		System.out.println(map.get(null));
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		//hashtable.put(null, "1");
		System.out.println(hashtable.size());
	}
}
