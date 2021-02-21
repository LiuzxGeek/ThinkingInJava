package com.java.thinking.leetcode.sim;

public class MaxProfitII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int buyPrice = -1;
		int sellPrice = -1;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i < prices.length - 1) {
				if (prices[i + 1] > prices[i]) {
					if (buyPrice == -1) {
						buyPrice = prices[i];
					}
					sellPrice = prices[i + 1];
				} else {
					maxProfit += sellPrice - buyPrice;
					buyPrice = -1;
					sellPrice = -1;
				}
			}
		}
		if (sellPrice > 0) {
			// 处理边界值，数字一直变大
			maxProfit += sellPrice - buyPrice;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		MaxProfitII profitII = new MaxProfitII();
		System.out.println(profitII.maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2 }));
	}
}
