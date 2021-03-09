package com.java.thinking.leetcode.sim;

public class IsOneBitCharacter {
	public boolean isOneBitCharacter(int[] bits) {
		int number = 0;
		for (int i = 0; i < bits.length; i++) {
			if (number == 0 || number == -1) {
				// 代表不需要关心的0和清理标识
				number = bits[i];
			} else {
				// 清理之前的字符
				number = -1;
			}
		}
		return number == 0;
	}

	public boolean isOneBitCharacter2(int[] bits) {
		// 1+x为true，步长加2，0则步长加1
		int index = 0;
		while (index < bits.length - 1) {
			if (bits[index] == 0) {
				// 如果直到倒数第二个，刚好0，步长加1，刚好等于最后一个的下标
				index++;
			} else {
				// 如果直到倒数第二个，刚好1，步长加2，大于最后一个的下标
				index += 2;
			}
		}
		// 只有两种可能 ，一种等于，一种大于
		return index == bits.length - 1;
	}

	public static void main(String[] args) {
		int r = Integer.valueOf('9'+"");
		System.out.println(r);
	}
}
