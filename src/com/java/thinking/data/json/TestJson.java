package com.java.thinking.data.json;

import com.alibaba.fastjson.JSONArray;

/*
*@author:liuxian
*@date:2019年5月31日
*/
public class TestJson {
	public static void main(String[] args) {
		JSONArray array = new JSONArray();
		array.add("a");
		array.add("b");
		System.out.println(array.toJSONString());
		double c = Double.valueOf("1w");
		System.out.println(c);
	}
}
