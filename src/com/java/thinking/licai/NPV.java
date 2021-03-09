package com.java.thinking.licai;

public class NPV {

	private static double getNpv(double share, int year, double intrest) {
		double result = 0;
		while (year > 0) {
			result += share / Math.pow(1 + intrest, year--);
		}
		return result;
	}

	/**
	 * 
	 * @param cash=净现金+折旧-资本支出-运营支出
	 *            现金流
	 * @param growth
	 *            公司永续增长率
	 * @param rate
	 *            折现率
	 * @param year
	 *            若干年后
	 * @return Sn=a1(1-q^n)/(1-q)
	 */
	private static double getValue(int cash, double growth, double rate, int year) {
		double q = (1 + growth) / (1 + rate);
		return cash * (1 - Math.pow(q, year)) / (1 - q); 
	}

	private static double getPrice(double profit, int year, double amount) {
		return year * profit / amount;
	}

	public static void main(String[] args) {
		int capital = 100000;
		// 12是正常回本周期，16是最长的
		int year = 12;
		int share = capital / year + 10000;
		double intrest = 0.1;
		System.out.println(getNpv(share, year, intrest));

		int cash = 10;
		double growth = 0.2;
		double rate = 0.1;
		System.out.println(getValue(cash, growth, rate, year));

		double profit = 200;
		System.out.println(getPrice(profit, 16, 60.16));

	}
}
