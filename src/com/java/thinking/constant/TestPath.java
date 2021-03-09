package com.java.thinking.constant;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class TestPath {
	private static void TestUrl() {
		try {
			URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
			System.out.println("URL 为：" + url.toString());
			System.out.println("协议为：" + url.getProtocol());
			System.out.println("验证信息：" + url.getAuthority());
			System.out.println("文件名及请求参数：" + url.getFile());
			System.out.println("主机名：" + url.getHost());
			System.out.println("路径：" + url.getPath());
			System.out.println("端口：" + url.getPort());
			System.out.println("默认端口：" + url.getDefaultPort());
			System.out.println("请求参数：" + url.getQuery());
			System.out.println("定位位置：" + url.getRef());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String launchUrl = "https://xixi-beta.media.com/app/info/detail/5a52f0ba8e1c3a52d52cfc4d?access_token=dae8aeaf231e4ece9dc8a816b40dbeee0eddacb185557fe7bb6248dd73cce7ef&member_id=59dad01f8e1c3a4a13dc8fc7&t=1516159937588#j2se";
		URI uri = URI.create(launchUrl);
		System.out.println("path:" + uri.getPath());
		String query = uri.getQuery();
		System.out.println(query);
		String[] querys = query.split("&");
		StringBuffer buffer = new StringBuffer();
		for (String q : querys) {
			String[] qs = q.split("=");
			if ("access_token".equals(qs[0])) {
				qs[1] = "newToken";
				handleStringBuffer(buffer, qs);
			} else if ("member_id".equals(qs[0])) {
				qs[1] = "newId";
				handleStringBuffer(buffer, qs);
			} else if ("t".equals(qs[0])) {
				qs[1] = String.valueOf(System.currentTimeMillis());
				handleStringBuffer(buffer, qs);
			} else {
				buffer.append(q);
			}
		}
		String newQuery = buffer.substring(0, buffer.length() - 1);
		System.out.println(newQuery);
		String newLaunchUrl = launchUrl.replace(query, newQuery);
		System.out.println(newLaunchUrl);
	}

	private static void handleStringBuffer(StringBuffer buffer, String[] qs) {
		buffer.append(qs[0]);
		buffer.append("=");
		buffer.append(qs[1]);
		buffer.append("&");
	}
}
