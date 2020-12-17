package com.java.thinking.url;

import java.net.URI;

/*
*@author:liuxian
*@date:2019年10月22日
*/
public class TestUri {
	public static void main(String[] args) {
		String url = "https://h5.m.taobao.com/trip/rx-travel-talent/home/index.html?titleBarHidden=1&amp;_fli_wk=true&amp;id=2206823776305&_projVer=1.3.0";
		url = url.replace("tbopen", "http");
		URI uri = URI.create(url);
		System.out.println("Authority:" + uri.getAuthority());
		System.out.println("getFragment:" + uri.getFragment());
		System.out.println("getHost:" + uri.getHost());
		System.out.println("getPath:" + uri.getPath());
		System.out.println("getName:" + uri.getPath().split("/")[1]);
		System.out.println("getQuery:" + uri.getQuery());
		System.out.println("getScheme:" + uri.getScheme());
		System.out.println("getUserInfo:" + uri.getUserInfo());
		System.out.println("toString:" + uri.toString());

		String path = "https://m.facebook.com/WHO/videos/2034333113367871/?refsrc=https://m.facebook.com/154163327962392/posts/3664198043625552/&_rdr";
		String child = "https://www.facebook.com/154163327962392/posts/3664198043625552/?sfnsn=mo";
		System.out.println(path);
		System.out.println(child.substring(child.lastIndexOf("."), child.lastIndexOf("/")));
		System.out.println(path.contains(child.substring(child.lastIndexOf("."), child.lastIndexOf("/"))));
	}
}
