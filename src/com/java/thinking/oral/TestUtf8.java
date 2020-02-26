package com.java.thinking.oral;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/*
*@author:liuxian
*@date:2019年12月30日
*/
public class TestUtf8 {
	public static void main(String[] args) {
		String result = "https://scontent-hkg3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/78884489_2439004766364860_1170325183296237391_n.jpg?_nc_ht=scontent-hkg3-1.cdninstagram.com&_nc_cat=108&_nc_ohc=xGkoZv117QcAX-I_QqR&oh=211b774ed2277c2cf532b69a673eb41d&oe=5EAF68F2";
		String resutl = "https://scontent-hkg3-1.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/78884489_2439004766364860_1170325183296237391_n.jpg?_nc_ht=scontent-hkg3-1.cdninstagram.com&_nc_cat=108&_nc_ohc=xGkoZv117QcAX-I_QqR&oh=211b774ed2277c2cf532b69a673eb41";
		try {
			System.out.println(result.replace("\\u0026", "&"));
			System.out.println(resutl.replace("\\u0026", "&"));
			System.out.println(new String(result.getBytes("UTF-8"), "UTF-8"));
			String decoderUrl = URLDecoder.decode(result, "UTF-8");
			System.out.println(decoderUrl);
			String child = "display_url:https://scontent-hkg3-2.cdninstagram.com/v/t51.2885-15/fr/e15/s1080x1080/77196075_2750185535033051_1670435774387442168_n.jpg?_nc_ht=scontent-hkg3-2.cdninstagram.com\u0026_nc_cat=111\u0026_nc_ohc=l_zTkYwEgnwAX8VWb9k\u0026oh=f92f8b8ef2c7a177be91a69bd0cdf403\u0026oe=5E913446";
			System.out.println(child.substring(12, child.length()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
