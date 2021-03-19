package com.java.thinking.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Calculate {
	public int calculate(String s) {
		s = s.replace(" ", "");
		boolean isIlligal = s.startsWith("-(");
		s = s.replace("(", "").replace(")", "");
		char[] attr = s.toCharArray();
		int len = attr.length, sum = 0, index = isIlligal ? 1 : 0, left = 0, right = 0;
		Boolean add = null;
		for (int i = index; i < len; i++) {
			if (attr[i] == '+') {
				sum = caculate(left, right, attr, add, sum, s);
				add = true;
				// 移动数字的位置，相等代表无数据需要处理
				left = right = i + 1;
			} else if (attr[i] == '-') {
				sum = caculate(left, right, attr, add, sum, s);
				add = false;
				left = right = i + 1;
			} else {
				if (i == (isIlligal ? 1 : 0)) {
					// 首个数字处理，
					left = i;
					right = left + 1;
				} else {
					// 连续数字，右移即可
					right++;
				}
				// 防止最后都是数字，但并未计算
				if (i == len - 1) {
					sum = caculate(left, right, attr, add, sum, s);
				}
			}
		}
		if (isIlligal) {
			sum = 0 - sum;
		}
		return sum;
	}

	private int caculate(int left, int right, char[] attr, Boolean add, int sum, String s) {
		int value = 0;
		if (right - left == 1) {
			value = Character.isDigit(attr[left]) ? attr[left] - '0' : 0;
		} else if (right - left > 1) {
			value = Integer.valueOf(s.substring(left, right));
		}
		if (add == null) {
			sum = value;
		} else if (add) {
			sum += value;
		} else {
			sum -= value;
		}
		return sum;
	}

	public int calculate2(String s) {
		int ans = 0;
		Deque<Integer> queue = new LinkedList<Integer>();
		int sign = 1;
		queue.add(sign);
		int i = 0, n = s.length();
		char[] attr = s.toCharArray();
		while (i < n) {
			if (attr[i] == ' ') {
				i++;
			} else if (attr[i] == '+') {
				sign = queue.peek();
				i++;
			} else if (attr[i] == '-') {
				sign = -queue.peek();
				i++;
			} else if (attr[i] == '(') {
				// 把上个符号加进来
				queue.push(sign);
				i++;
			} else if (attr[i] == ')') {
				// 把上个符号减出去
				queue.pop();
				i++;
			} else {
				// 处理数字
				int num = 0;
				while (i < n && Character.isDigit(attr[i])) {
					num = num * 10 + attr[i] - '0';
					i++;
				}
				ans += sign * num;
			}
		}
		return ans;
	}

	public int calculate3(String s) {
		int ans = 0, num = 0, i = 0, len = s.length();
		char[] attr = s.toCharArray();
		// 由于只有加减乘除，没有括号，所以本题思路是，先算乘除，使用堆来存储数据，这样在遇到乘除时，方便取出最后一个数，与当前数进行算数计算
		Deque<Integer> stack = new LinkedList();
		// 默认设置上个符号为正号
		char preSign = '+';
		while (i < len) {
			if (Character.isDigit(attr[i])) {
				// 如果是数字，则需要下标增加，循环计数；多数位时，要乘以10，用于处理进制
				num = num * 10 + attr[i] - '0';
			}
			if ((!Character.isDigit(attr[i]) && attr[i] != ' ') || i == len - 1) {
				// 是符号时，以及最后一个元素
				switch (preSign) {
				case '+':
					stack.push(num);
					break;
				case '-':
					stack.push(-num);
					break;
				case '*':
					stack.push(stack.pop() * num);
					break;
				case '/':
					stack.push(stack.pop() / num);
					break;
				}
				// 保留上个符号
				preSign = attr[i];
				// 重置num
				num = 0;
			}
			i++;
		}
		// 这样，得出的结果，只需要相加即可
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}

	private void removeBracket() {
		Queue<Integer> queue = new LinkedList<>();
		Deque<Integer> deque = new LinkedList<>();
		queue.offer(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		// for (int i = 0; i < 4; i++) {
		// System.out.println(queue.poll());
		// }
		deque.push(1);
		deque.push(2);
		deque.push(3);
		deque.push(4);
		for (int i = 0; i < 4; i++) {
			System.out.println(deque.removeLast());
		}
	}

	public static void main(String[] args) {
		String s = "3-(2-3)";
		// s = "2147483647";
		// s = "-2+ 1";
		// s = "1 + 1";
		// s = "1-11";
		// s = "2-(5-6)";
		Calculate calculate = new Calculate();
		System.out.println(calculate.calculate2(s));
		// calculate.removeBracket();
		s = " 3+5 / 2 ";
		s = "3+2*2";
		System.out.println(calculate.calculate3(s));
	}
}
