package com.java.thinking.container;

import java.util.Iterator;
import java.util.Stack;

public class TestStack {
	public static void main(String[] args) throws InterruptedException {
		Stack<String> stack = new Stack<>();
		stack.add("1");
		stack.add("2");
		stack.add("3");
		Iterator<String> iterator = stack.iterator();
		while (iterator.hasNext()) {
			System.out.println(stack.pop());
		}
	}
}
