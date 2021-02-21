package com.java.thinking.leetcode.sim;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int min = prices[0];
		int max = prices[0];
		int temMin = prices[0];
		int temMax = prices[0];
		for (int price : prices) {
			if (price < temMin) {
				temMin = price;
				// 重新计数
				temMax = price;
			} else if (price > temMax) {
				temMax = price;
			}
			if (temMax - temMin > max - min) {
				max = temMax;
				min = temMin;
			}
		}
		int result = max - min;
		return result > 0 ? result : 0;
	}

	public static void main(String[] args) {
		MaxProfit profit = new MaxProfit();
		System.out.println(profit.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
}
