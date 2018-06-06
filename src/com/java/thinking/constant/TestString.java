package com.java.thinking.constant;

import java.io.File;

public class TestString {
	public static void main(String[] args) {
		System.out.println("".trim());
		String url = "https://xihu-beta.unimedia.com/app/post/detail/5a151ba78e1c3a5124fd7b1a?env=android&memberID=59dad01f8e1c3a4a13dc8fc7";
		String id = url.substring(url.indexOf("detail/"), url.indexOf("?")).replace("detail/", "");
		System.out.println(id);
		String img = "https://cdn-beta.unimedia.com/uploads/59cfb0eb8e1c3a291567683d/1512118939/a0979a77ee5176760eee52418b9475a0_750x1334.jpg";
		String[] arr = img.split("/");

		System.out.println(arr[arr.length - 1]);

		String detailUrl = "/posts/5a323f998e1c3a64bafed7b1/comments/5a333f048e1c3a73b5976443/child?t=1513737972900";
		String articleId = detailUrl.substring(detailUrl.indexOf("posts/"), detailUrl.indexOf("/comments"))
				.replace("posts/", "");
		System.out.println(articleId);

		System.out.println("".equals(null));
		File file = new File("/lint");
		System.out.println(file == null);
		url = "https://xihu-beta.unimedia.com/app/video/detail/5a6193ea8e1c3a78439beed7?access_token?=54394f8a1c9ed917451d8e08a1e9b70351cd67ab72c5a5d21656d0da37dad865&member_id=59daecf58e1c3a4a13dc935d&t=1520498747631";
		String head = url.substring(0, url.indexOf("?"));
		String headArr[] = head.split("/");
		System.out.println(headArr[headArr.length - 1]);
		testStartWith();
	}

	public static void testStartWith() {
		String str = "{\"type\":6,\"data\":{\"target_id\":\"\",\"object\":{\"iconUrl\":\"http:\\/\\/test.ihuajian.com\\/uploads\\/images\\/201801\\/c9a4b6b565c.png\",\"name\":\"香吻\",\"id\":1005,\"inValue\":190,\"remark\":\"亲我一下\",\"extendType\":1,\"currentGiftCount\":1,\"type\":3,\"comboList\":[],\"iconUrlReserve\":\"http:\\/\\/test.ihuajian.com\\/uploads\\/images\\/201801\\/bb4bce959e1.png\"},\"PropId\":1005,\"userName\":\"\",\"userId\":\"\",\"PropAmount\":1,\"avatar\":\"\",\"sex\":1}}";
		System.out.println(str.startsWith("{\"type\":6"));
	}
}
