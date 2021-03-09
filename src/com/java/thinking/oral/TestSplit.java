package com.java.thinking.oral;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@author:liuxian
*@date:2019年5月10日
*/
public class TestSplit {
	public static void main(String[] args) {
		testKuaishou();
		// testFacebook();
		// testTwitter();
		System.out.println(1587626548005L - System.currentTimeMillis());
	}

	private static void testTwitter() {
		String format = getResult("https://pbs.twimg.com/profile_images/1004638591308435457/tiacF_Yg_x96.jpg",
				"(?i)format=[^\\u4e00-\\u9fa5]+&name=");
		System.out.println(format);
	}

	private static void testFacebook() {
		String result = "https://www.facebook.com/100002752294630/posts/2403651949736525/?sfnsn=mo";
		String[] attr = result.split("/");
		System.out.println(attr[3]);
		result = "https://m.facebook.com/story.php?story_fbid=2404020399699680&id=100002752294630&sfnsn=mo";
		attr = result.split("&id=")[1].split("&");
		System.out.println(attr[0]);
	}

	private static void testKuaishou() {
		String[] attr = getArrayByRegex("kwai://work/5255137840532160616?userId=1761868100", "\\?userId\\=(.*?) ");
		System.out.println(attr[0]);
		System.out.println(attr[1]);

		String result = "srcNoMark&#34;:&#34;https://jsmov2.a.yximgs.com/upic/2019/11/27/11/BMjAxOTExMjcxMTU0MTBfMTQ0NDMzOTUxXzE5OTI1OTAxNTA2XzJfMw==_b_B60ae5a4089c438371705bf25b77b834b.mp4";
		System.out.println(result.split("srcNoMark")[1].split(".mp4")[0].replace("&#34;:&#34;", "") + ".mp4");
	}

	private void test() {
		String[] attr = getArrayByRegex(
				"Response{protocol=http/1.1, code=200, message=OK, url=http://v26-dy.ixigua.com/d224a779d9196948eb81602a811330be/5e5ccbec/video/m/220f89783845cd546b8b1ea94af3e8c12ba11631a57600008b781fe381c4/?a=1128&br=0&bt=2695&cr=0&cs=0&dr=0&ds=6&er=&l=2020030216032701002806807802011FE4&lr=&qs=0&rc=M3Rrbzdkd288bzMzaGkzM0ApPDg6ODk4M2VnNzU3PDxoaWdeay5vZTViYjJfLS1iLS9zczIuNjZfMS41L2BiNDQ0MGI6Yw%3D%3D&vl=&vr=}",
				"url\\=(.*?)\\}");
		System.out.println(attr[0]);
		System.out.println(attr[1]);
	}

	public static String replaceAccessTokenReg(String url, String name, String accessToken) {
		url = url.replaceAll("(" + name + "=[^&]*)", name + "=" + accessToken);
		return url;
	}

	public static void test126() {
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

	public static String[] getArrayByRegex(String content, String regex) {
		String[] resultAttr = new String[2];
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		while (m.find()) {
			// 包含的字符
			resultAttr[0] = m.group(0);
			// 不包括这两个字符
			resultAttr[1] = m.group(1);
		}
		return resultAttr;
	}

	public static String getResult(String content, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(content);
		while (m.find()) {
			return m.group();
		}
		return null;
	}
}
