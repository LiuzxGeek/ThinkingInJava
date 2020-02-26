package com.java.thinking.oral;

/*
*@author:liuxian
*@date:2019年5月10日
*/
public class TestSplit {
	public static void main(String[] args) {

		String str = "http://imglf6.nosdn0.126.net/img/ditvMG1PUU9xTkIxS1lhRnRjeDU4U0NNcUNTSFBFYkxaVzI5ZTk2RTlEOTE1Q0ZxOUErWndRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg";
		String[] array = str.split("&");
		int targetIndex = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i].startsWith("thumbnail=")) {
				targetIndex = i;

			} else {
				builder.append(array[i]);
			}
		}
		System.out.println(replaceAccessTokenReg(str, "thumbnail", "840x0"));
		System.out.println(true || false ? "do" : "donot");
	}

	public static String replaceAccessTokenReg(String url, String name, String accessToken) {
		url = url.replaceAll("(" + name + "=[^&]*)", name + "=" + accessToken);
		return url;
	}
}
