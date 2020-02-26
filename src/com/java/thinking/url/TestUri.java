package com.java.thinking.url;

import java.net.URI;

/*
*@author:liuxian
*@date:2019年10月22日
*/
public class TestUri {
	public static void main(String[] args) {
		URI uri = URI.create("https://youtu.be/aCVw6igO7U4");
		System.out.println(uri.getAuthority());
		System.out.println(uri.getFragment());
		System.out.println(uri.getHost());
		System.out.println(uri.getPath().endsWith("/"));
		System.out.println(uri.getQuery());
		System.out.println(uri.getScheme());
		System.out.println(uri.getUserInfo());
		System.out.println(uri.toString());
	}
}
