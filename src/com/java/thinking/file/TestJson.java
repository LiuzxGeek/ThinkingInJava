package com.java.thinking.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

	private static void testNebula() {
		UploadUtils.uploadNebulaLog();
		String a = "hello";
		System.out.println(a.getBytes().length);
	}

	public static void main(String[] args) {
		JSONArray jsonArray = new JSONArray();
		System.out.println(jsonArray.size());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "time");
		jsonArray.add(jsonObject);
		System.out.println(jsonArray.toJSONString());
		jsonObject.put("id", "new_time");
		System.out.println(jsonArray.getJSONObject(0).get("id"));
		System.out.println(jsonArray.toJSONString());
		for (int i = 0; i < 15; i++) {
			jsonObject = new JSONObject();
			jsonObject.put(String.valueOf(i), System.currentTimeMillis());
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray.size());

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject1 = jsonArray.getJSONObject(i);
			if (i == 10) {
				System.out.println(jsonArray.toJSONString());
				System.out.println(jsonObject1.get(String.valueOf(i-1)));
				jsonObject1.put(String.valueOf(9), 20);
				System.out.println(jsonArray.toJSONString());
				break;
			}
		}
	}
}
