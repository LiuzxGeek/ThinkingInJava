package com.java.thinking.alto;

import java.util.Arrays;
import java.util.List;

public class TestBinary {
	/**
	 * 二进制算法
	 * 
	 * @param num
	 * @return
	 */
	private static String getBinary(int num) {
		StringBuilder builder = new StringBuilder();
		while (num != 0) {
			int left = num % 2;
			num /= 2;
			builder.append(left);
		}
		return builder.reverse().toString();
	}

	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			int count = 0;
			String binary = Integer.toBinaryString(i);
			binary.replace("0", "");
			char[] attr = binary.toCharArray();
			for (char ch : attr) {
				if (ch == '1') {
					count++;
				}
			}
			ans[i] = count;
		}
		return ans;
	}

	public static int[] countBits2(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			String binary = Integer.toBinaryString(i);
			binary = binary.replace("0", "");
			ans[i] = binary.length();
		}
		return ans;
	}

	public static Integer[] countBits3(int num) {
		Integer[] ans = new Integer[num + 1];
		ans[0] = 0;
		for (int i = 1; i <= num; i++) {
			ans[i] = getBinary1Count(i);
		}
		return ans;
	}

	public static int[] countBits4(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			// 偶数，跟除2的1个数一样
			ans[i] = ans[i >> 1] + (i & 1);
			// 奇数，则需要+1，（奇数的最后一位始终为1，而1的前位始终为0，所以只用比较最后1位为1即可）
		}
		return ans;
	}

	private static int getBinary1Count(int num) {
		int count = 0;
		while (num != 0) {
			int left = num % 2;
			num /= 2;
			if (left == 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(9));
		System.out.println(getBinary(9));
		List<Integer> list = Arrays.asList(countBits3(5));
		System.out.println(list);
	}
}
