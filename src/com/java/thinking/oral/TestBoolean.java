package com.java.thinking.oral;

public class TestBoolean {
	public static void main(String[] args) {
		String picUrl = "static.qichechaoren.jpg";
		if (picUrl.contains("static.qichechaoren.com") && picUrl.endsWith(".png") || picUrl.endsWith(".jpg")) {
			System.out.println(true);
		}
		System.out.println(false);
	}
}
