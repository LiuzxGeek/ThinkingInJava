package com.java.thinking.leetcode.sim;

import java.util.HashMap;
import java.util.Map;

public class Roman2Int {

	public int romanToInt(String s) {
		int count = 0;
		if (null != s && "" != s) {
			Map<String, Integer> map = new HashMap<>();
			map.put("I", 1);
			map.put("IV", 4);
			map.put("V", 5);
			map.put("IX", 9);
			map.put("X", 10);
			map.put("XL", 40);
			map.put("L", 50);
			map.put("XC", 90);
			map.put("C", 100);
			map.put("CD", 400);
			map.put("D", 500);
			map.put("CM", 900);
			map.put("M", 1000);
			char[] ch = s.toCharArray();
			for (int i = 0, size = ch.length; i < size; i++) {
				if (i + 1 < size) {
					String key = new String(new char[] { ch[i], ch[i + 1] });
					Integer value = map.get(key);
					if (value != null) {
						i++;
						count += value;
						continue;
					}
				}
				Integer value = map.get(ch[i] + "");
				if (value != null) {
					count += value;
				}
			}
		}
		return count;
	}

	public int romanToInt2(String s) {
		int count = 0;
		if (null != s && "" != s) {
			Map<Character, Integer> map = new HashMap<>();
			map.put('I', 1);
			map.put('V', 5);
			map.put('X', 10);
			map.put('L', 50);
			map.put('C', 100);
			map.put('D', 500);
			map.put('M', 1000);
			char[] ch = s.toCharArray();
			for (int i = 0, size = ch.length; i < size; i++) {
				if (i + 1 < size) {
					Integer cur = map.get(ch[i]);
					Integer nex = map.get(ch[i + 1]);
					if (cur < nex) {
						count -= cur;
						count += nex;
						i++;
						continue;
					}
				}
				Integer value = map.get(ch[i]);
				if (value != null) {
					count += value;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Roman2Int roman2Int = new Roman2Int();
		System.out.println(roman2Int.romanToInt2("IXII"));
	}
}
