package com.java.thinking.constant;

import java.util.ArrayList;
import java.util.List;

/*
*@author:liuxian
*@date:2018年10月27日
*/
public class TestTime {
	public static void main(String[] args) {
		long minus = 1556607827182l - 1556605012682l;
		long second = minus / 1000;
		long minute = second / 60;
		System.out.println(minus);
		System.out.println(second + "秒");
		System.out.println(minute + "分");
		//10033开始时间：1557302859431 5秒后在 西瓜 直播间开启红包雨开始时间：1557302859980
		System.out.println(1557302859980l - 1557302859431l);
		System.out.println(1557303149562l - 1557303149090l);
		System.out.println(1557303209083l - 1557303208664l);
		System.out.println(1557303273162l - 1557303273162l);
	}

	class Student {
		private int age;
		private String name;
	}

	private static void testSpecial() {
		System.out.println(1540625277983l - 1540625274549l);
		int connectTimeout;
		connectTimeout = 10_000;
		System.out.println(connectTimeout);
		System.out.println(520356 / 1024);
		List<Object> list = new ArrayList<>();
		for (Object str : list) {
			System.out.println(str);
		}
		list.add(null);
		System.out.println(list.size());
	}

}
