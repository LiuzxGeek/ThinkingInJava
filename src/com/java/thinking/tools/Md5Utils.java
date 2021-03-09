package com.java.thinking.tools;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
*@author:liuxian
*@date:2018年8月16日
*/
public class Md5Utils {
	public static String cacheKey(String str) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
		byte[] digest = messageDigest.digest();
		String sb = "";
		for (byte b : digest) {
			sb += String.format("%02x", b);// 取2位的16进制
		}
		System.out.println("digest长度：" + digest.length);
		System.out.println("字符结果长度：" + sb.length());
		return sb;
	}

	public static void main(String[] args) throws Exception {
		String str = cacheKey("http://video.ihuajian.com/uploads/user/gift/prop_svg_url/5b695fbc3633f.svga");
		System.out.println(str);
		// System.out.println("05b8668f0b702e36808a29a82823d825");
		// System.out.println("05b8668f0b702e36808a29a82823d825".length());
		//
		// System.out.println(String.format("%1$,09d", -3123));
		// System.out.println(String.format("%1$9d", -31));
		// System.out.println(String.format("%1$-9d", -31));
		// System.out.println(String.format("%1$(9d", -31));
		// System.out.println(String.format("%1$#9x", 5689));
		// System.out.println(String.format("%02x", 5689));// 取两位数的16进制
		System.out.println(cacheKey(
				"http://imglf6.nosdn0.126.net/img/eHJBeHlSUFlxWXpoT2Juc1ZCZTMrQnBVcnhVeFZIZThGa0JSTWFxZ29OcEZyY0JDb2JEYXRBPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg"));
		System.out.println(cacheKey(
				"http://imglf6.nosdn0.126.net/img/eHJBeHlSUFlxWXd6REQ0eVJnVEtjZG41ZTNFTzFqSlVORkwzaU5hSkdONzRxcFVmM2RvM1V3PT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg"));
	}
}
