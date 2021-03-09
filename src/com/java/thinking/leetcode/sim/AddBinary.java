package com.java.thinking.leetcode.sim;

/**
 * 二进制求和：同1，无升位为0，有升位为1（升位不变）；同0，无升位为0，有升位为1（升位减1）；1和0，无升位为1，有升位为0（升位不变）；
 * https://leetcode-cn.com/problems/add-binary/
 * 
 * @author fred
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		// 左边长
		char[] left = a.toCharArray();
		char[] right = b.toCharArray();
		if (a.length() < b.length()) {
			char[] tem = left;
			left = right;
			right = tem;
		}
		String result = "";
		int extra = 0;
		for (int i = left.length - 1, j = right.length - 1; i > -1; i--) {
			if (left[i] == '1' && j >= 0 && right[j] == '1') {
				// 1&1
				if (extra > 0) {
					result = '1' + result;
				} else {
					result = '0' + result;
					extra++;
				}
				j--;
			} else if (left[i] == '0' && j >= 0 && right[j] == '0') {
				// 0&0
				if (extra > 0) {
					result = '1' + result;
					extra--;
				} else {
					result = '0' + result;
				}
				j--;
			} else if (left[i] == '0' && j < 0) {
				// 0&0
				if (extra > 0) {
					result = '1' + result;
					extra--;
				} else {
					result = '0' + result;
				}
			} else {
				// 1&0
				if (extra > 0) {
					result = '0' + result;
				} else {
					result = '1' + result;
				}
				if (j >= 0) {
					j--;
				}
			}
		}
		// 如果还有多余，则继续1&0
		while (extra > 0) {
			result = '1' + result;
			extra--;
		}
		return result;
	}

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(Integer.parseInt(addBinary.addBinary("11111111111111111111111111111111", "10"), 2));
	}
}
