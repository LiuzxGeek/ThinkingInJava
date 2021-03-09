package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*@author:liuxian
*@date:2018年5月7日
*/
public class TestMap {
	public static void main(String[] args) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.get("123");
		Map<String, List<Long>> map2 = new HashMap<>();
		if (!map2.containsKey("2018-11-23")) {
			map2.put("2018-11-23", new ArrayList<>());
		}
		List<Long> list = map2.get("2018-11-23");
		list.add(2l);
		System.out.println(map2.get("2018-11-23").size());
		System.out.println(Double.valueOf("0"));
		System.out.println(tableSizeFor(1));
		Map<String, Integer> map3 = new HashMap<>();
		System.out.println(map3.size());
		Map<String, Integer> map4 = new HashMap<>(2);
		System.out.println(map4.size());
	}

	static final int tableSizeFor(int cap) {
		int MAXIMUM_CAPACITY = 1 << 30;
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
