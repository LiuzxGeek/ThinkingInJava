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
	}
}
