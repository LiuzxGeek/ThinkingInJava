package com.java.thinking.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class TestGson {
	public static void main(String[] args) {
		Gson gson;
		IMap iMap = new BBMap();
		iMap.size();

		JsonArray array = new JsonArray();
		array.add("http://1234/12341");
		System.out.println(array.toString().replace("\"", ""));

	}
}
