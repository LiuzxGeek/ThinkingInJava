package com.java.thinking.leetcode.sim;

public class ClimbStairs {
	public int climbStairs(int n) {
		if (n >= 2) {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
		return 1;
	}

	public int climbStairs(int n, int count) {
		if (n >= 2) {
			return climbStairs(n - 1, count) + climbStairs(n - 2, count);
		}
		return 1;
	}

	public long climbStairs2(int n) {
		// 全是1
		long count = 1;
		int tt = 0;
		while (2 * tt++ < n) {
			// 1的个数+2的个数
			int sum = n - tt * 2 + tt;
			long result = getCombineResult2(sum, tt);
			System.out.println("底：" + n / 2 + " tt:" + tt + " result:" + result);
			count += result;
		}
		return count;
	}

	/**
	 * 排列
	 * 
	 * @param sum
	 * @param logrithm
	 * @return
	 */
	public long getRankResult(int sum, int logrithm) {
		long top = 1;
		int bottom = sum - logrithm;
		int tem = sum;
		while (tem > bottom) {
			top *= tem--;
		}
		return top;
	}

	/**
	 * 组合
	 * 
	 * @param sum
	 * @param logrithm
	 * @return
	 */
	public long getCombineResult(int sum, int logrithm) {
		int tem = logrithm;
		long result = getRankResult(sum, logrithm);
		while (tem > 0) {
			// m的阶乘
			result /= tem--;
		}
		return result;
	}

	public long getCombineResult2(int sum, int logrithm) {
		long top = 1;
		int bottom = sum - logrithm;
		int tem = sum;
		int ch = logrithm;
		while (tem > bottom) {
			top *= tem--;
			while (ch > 0 && top % ch == 0) {
				top /= ch--;
			}

		}
		return top;
	}

	public static void main(String[] args) {
		ClimbStairs climbStairs = new ClimbStairs();
		// 1134903170
		System.out.println(climbStairs.climbStairs2(44));
		System.out.println(climbStairs.climbStairs(44));
		System.out.println(Integer.MAX_VALUE);
	}
}
