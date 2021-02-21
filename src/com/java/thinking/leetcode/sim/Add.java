package com.java.thinking.leetcode.sim;

public class Add {

	public int add(int a, int b) {
		String as = Integer.toBinaryString(a);
		String bs = Integer.toBinaryString(b);
		int count = 0;
		StringBuilder builder = new StringBuilder();
		int extra = 0;
		while (count < as.length() || count < bs.length()) {
			int ac = 0, bc = 0;
			if (as.length() - count - 1 >= 0) {
				ac = as.charAt(as.length() - count - 1) - '0';
			}
			if (bs.length() - count - 1 >= 0) {
				bc = bs.charAt(bs.length() - count - 1) - '0';
			}
			// 二进制求和：同1，无升位为0，有升位为1（升位不变）；同0，无升位为0，有升位为1（升位减1）；1和0，无关升位，为1
			if (ac == 1 && bc == 1) {
				if (extra > 0) {
					builder.append("1");
					// 进位了，所以不处理extra
				} else {
					builder.append("0");
					extra++;
				}
			} else if (ac == 1 || bc == 1) {
				// 进位在此无作用
				if (extra > 0) {
					builder.append("0");
				} else {
					builder.append("1");
				}
			} else {
				if (extra > 0) {
					builder.append("1");
					extra--;
				} else {
					builder.append("0");
				}
			}
			count++;
		}
		if (extra > 0) {
			builder.append("1");
		}
		return (int) Long.parseLong(builder.reverse().toString(), 2);
	}

	public int minus(int a, int b) {
		boolean isNegtive = false;
		if (a < b) {
			isNegtive = true;
			int tem = a;
			a = b;
			b = tem;
		}
		String as = Integer.toBinaryString(a);
		String bs = Integer.toBinaryString(b);
		int count = 0;
		StringBuilder builder = new StringBuilder();
		// 借位
		int extra = 0;
		while (count < as.length() || count < bs.length()) {
			int ac = 0, bc = 0;
			if (as.length() - count - 1 >= 0) {
				ac = as.charAt(as.length() - count - 1) - '0';
			}
			if (bs.length() - count - 1 >= 0) {
				bc = bs.charAt(bs.length() - count - 1) - '0';
			}
			if (ac == 1 && bc == 1) {
				if (extra > 0) {
					builder.append("1");
				} else {
					builder.append("0");
				}
			} else if (ac == 1 && bc == 0) {
				if (extra > 0) {
					builder.append("0");
					// 还1位
					extra--;
				} else {
					builder.append("1");
				}
			} else if (ac == 0 && bc == 1) {
				if (extra > 0) {
					builder.append("0");
				} else {
					builder.append("1");
					// 借1位为2
					extra++;
				}
			} else {
				if (extra > 0) {
					builder.append("1");
				} else {
					builder.append("0");
				}
			}
			count++;
		}
		return (int) Long.parseLong(builder.reverse().toString(), 2) * (isNegtive ? -1 : 1);
	}

	public static void main(String[] args) {
		Add add = new Add();
		int a = 33;
		int b = 101;
		System.out.println(add.add(a, b));
		System.out.println(add.minus(a, b));
		System.out.println(Math.multiplyExact(2, 3));
		System.out.println(Math.subtractExact(20, 3));
		System.out.println(Math.floorDiv(21, 3));
		System.out.println(Math.sqrt(100));
		System.out.println(60070 / 2 * (60070 + 1) - 1804289383);
		System.out.println((3 + 1) >> 1);
	}
}
