package com.java.thinking.constant;

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
	}
}
