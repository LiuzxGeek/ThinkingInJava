package com.java.thinking.leetcode.sim;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 
 * @author fred
 *
 */
public class RightChar {
	static Map<String, String> map = new HashMap<>(3);

	public boolean isValid(String s) {
		if (s.equals("")) {
			return true;
		} else if (s.length() % 2 != 0) {
			return false;
		}
		String key = s.substring(0, 1);
		String value = map.get(key);
		if (value == null) {
			return false;
		}
		char[] ch = s.toCharArray();
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < ch.length; i++) {
			if (key.equals(ch[i] + "")) {
				startIndex = i;
			} else if (value.equals(ch[i] + "")) {
				endIndex = i;
				break;
			}
		}
		if (endIndex == -1) {
			return false;
		} else {
			String t = s.substring(startIndex, endIndex + 1);
			if (t.length() % 2 != 0) {
				// 没有足够的长度
				return false;
			}
			System.out.println("startIndex:" + startIndex + " endIndex:" + endIndex);
			String start = s.substring(0, startIndex);
			String middle = s.substring(startIndex + 1, endIndex);
			String end = s.substring(endIndex + 1);
			System.out.println("start:" + start + " middle:" + middle + " end:" + end);
			return isValid(start + middle + end);
		}
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
			else if (c == '{')
				stack.push('}');
			else if (stack.isEmpty() || c != stack.pop())
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		map.put("(", ")");
		map.put("[", "]");
		map.put("{", "}");
		RightChar rightChar = new RightChar();
		System.out.println(rightChar.isValid2("(()[])"));
	}
}
