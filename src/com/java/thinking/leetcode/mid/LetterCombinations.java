package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		combine(ans, map, digits.toCharArray(), 0, new StringBuilder());
		return ans;
	}

	public static void combine(List<String> ans, Map<Integer, String> map, char[] digits, int index,
			StringBuilder builder) {
		if (index == digits.length) {
			ans.add(builder.toString());
			return;
		}
		int key = digits[index] - '0';
		String value = map.get(key);
		for (int i = 0; i < value.length(); i++) {
			builder.append(value.charAt(i));
			combine(ans, map, digits, index + 1, builder);
			builder.deleteCharAt(index);
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
