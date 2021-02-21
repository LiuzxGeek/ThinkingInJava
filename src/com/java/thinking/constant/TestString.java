package com.java.thinking.constant;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TestString {
	public static final String BREAK_CHAR = "breakChar";

	public static void main(String[] args) {

		// testStartWith();
		// testHead();
		// testOutput();
		// testSplit();
//		testBreak();
//		System.out.println("  2019-08-17".replaceAll("&nbsp;", ""));
//		String url = "http://maxine-ve.lofter.com/post/18f158_1c8a5a034";
//		System.out.println(url.substring(0, url.indexOf(".com")) + ".com");
//		String userId = url.replace("http://", "").replace("https://", "");
//		userId = userId.substring(0, userId.indexOf(".lofter"));
//		System.out.println(userId);
		String result = "​​​http://t.cn/A6wFSlbh ​​​http://weibointl.api.weibo.com/share/149228028.html?weibo_id=4497803092825963";
		System.out.println(result.substring(result.lastIndexOf("http")));
		System.out.println(getSubString("小乖乖不乖就是狗"));
		result = "https://share.huoshan.com/pages/item/index.html?item_id=6924960199136529675&tag=10078&timestamp=1612789269&watermark=2&media_type=4&share_ht_uid=0&did=58516573068&iid=422633686705613&utm_medium=huoshan_android&tt_from=copy_link&app=live_stream&utm_source=copy_link&schema_url=sslocal%3A%2F%2Fitem%3Fid%3D6924960199136529675";
		result = result.substring(0, result.indexOf("?"));
		result = result.substring(result.lastIndexOf("."));
		System.out.println(result);
		System.out.println(System.currentTimeMillis());

	}

	private static String getSubString(String anchorName) {
		if (anchorName.length() > 7) {
			anchorName = anchorName.substring(0, 7) + "...";
		}
		return anchorName;
	}

	private static void testBreak() {
		String str = "http://imglf6.nosdn0.126.net/img/ampKNXpMZHNOS0FtRk5WWk14NmgrNUFpdW5oWk51NWc1b3ZFRTl2UElZWm8rNzFjTVFRVzVnPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg5p6d5qWgIExpbmRzYXluYW4gLyBpc3R5bGUtbGluZHNheS1uYW4ubG9mdC4uLg==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0breakCharhttp://imglf5.nosdn0.126.net/img/ampKNXpMZHNOS0FtRk5WWk14NmgrNTBqOWV6ZWx1d2ZhQTdHWjR4RVpObW9OYVVNSm1NQVZRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg5p6d5qWgIExpbmRzYXluYW4gLyBpc3R5bGUtbGluZHNheS1uYW4ubG9mdC4uLg==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0breakCharhttp://imglf3.nosdn0.126.net/img/ampKNXpMZHNOS0FtRk5WWk14NmgrNStPa3F1WUM3T2p2Ukd5Y3lsZnVDUTlsbkh1UWFBR3p3PT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg5p6d5qWgIExpbmRzYXluYW4gLyBpc3R5bGUtbGluZHNheS1uYW4ubG9mdC4uLg==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0breakCharhttp://imglf3.nosdn0.126.net/img/ampKNXpMZHNOS0FtRk5WWk14NmgrOEpVVVF0bFBYd05oVlc4YzZGTEg5WjBBdnZYTzZIb1dRPT0.jpg?imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg5p6d5qWgIExpbmRzYXluYW4gLyBpc3R5bGUtbGluZHNheS1uYW4ubG9mdC4uLg==&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=680&dx=32&dy=36&stripmeta=0";
		String[] source = Pattern.compile("breakChar").split(str, 0);
		List<String> list = Arrays.asList(source);
		for (String c : source) {
			System.out.println(c);
		}
	}

	private static void testLabel() {
		String str = "#米娜宁波# 【台风\"米娜\"将擦过或登陆浙江!宁波沿海进入III级防台!部分班线已停】据市气象台通报：今年第18号台风“米娜”9月29日17时加强为台风级，中心位于距宁波东南偏南1150公里洋面上，预计将以20公里左右时速向西北方向移动，30日夜里擦过或登陆台湾东北部，而后转向偏北方向移动，向浙江中北部沿海靠近，1日擦过或登陆浙江沿海北上，将严重影响我市。市气象台29日11时已发布台风警报[话筒]#宁波台风# （NBTV新闻中心）";
		String[] attr = str.split("#");
		String label = "";
		for (int i = 0; i < attr.length; i++) {
			System.out.println(attr[i]);
			if (i % 2 == 1) {
				label += "#" + attr[i] + "#";
			}
		}
		System.out.println(label);
	}

	private static void testIns() {
		System.out.println("/storage/emulated/0/DCIM/FastPig/Image/IMG_99a4aec047ebe27fc7123e8c06a562af.jpg"
				.contains("/storage/emulated/0/DCIM/FastPig"));
		System.out.println("今北勝久 在 Instagram 上发布：“浜寺公園でBBQ🍖\r\n#浜寺公園 #bbq🍖 \r\n#子供達は水鉄砲でびちょびちょ”".split("：“")[1]);
		String[] attr = "https://scontent-hkg3-2.cdninstagram.com/vp/e21cf1e8b8af9d4dca7b1908d0adb7a7/5E07D5E9/t51.2885-15/sh0.08/e35/s640x640/70976464_2936175179742561_2929394412238638745_n.jpg?_nc_ht=scontent-hkg3-2.cdninstagram.com&amp;_nc_cat=109 640w,https://scontent-hkg3-2.cdninstagram.com/vp/9e9abc08eca6e6824de3152c3b3c1c9c/5E0C722D/t51.2885-15/sh0.08/e35/s750x750/70976464_2936175179742561_2929394412238638745_n.jpg?_nc_ht=scontent-hkg3-2.cdninstagram.com&amp;_nc_cat=109 750w,https://scontent-hkg3-2.cdninstagram.com/vp/c451aeba8e280ea8faa45b30c97f1637/5DFDC02D/t51.2885-15/e35/s1080x1080/70976464_2936175179742561_2929394412238638745_n.jpg?_nc_ht=scontent-hkg3-2.cdninstagram.com&amp;_nc_cat=109 1080w"
				.split(",");
		for (String str : attr) {
			System.out.println(str);
		}
		String result = "  ,  ";
		System.out.println(result.length());
		System.out.println(result.trim().length());
	}

	private static void testSplit() {
		String fileUrl = "https://yrmanage-uat.huachat.com/uploads/gift/prop_svg_url/5bfb9fea159e6.bundle";
		FaceDownLoadBean bean = new FaceDownLoadBean(fileUrl);
		if (bean.fileUrl.startsWith("https")) {
			bean.fileUrl.replaceFirst("https", "http");
		}
		System.out.println(bean.fileUrl);
		if (bean.fileUrl.startsWith("https")) {
			bean.fileUrl = bean.fileUrl.replaceFirst("https", "http");
		}
		System.out.println(bean.fileUrl);
	}

	private static void testHead() {
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
	}

	public static void testStartWith() {
		String str = "{\"type\":6,\"data\":{\"target_id\":\"\",\"object\":{\"iconUrl\":\"http:\\/\\/test.ihuajian.com\\/uploads\\/images\\/201801\\/c9a4b6b565c.png\",\"name\":\"香吻\",\"id\":1005,\"inValue\":190,\"remark\":\"亲我一下\",\"extendType\":1,\"currentGiftCount\":1,\"type\":3,\"comboList\":[],\"iconUrlReserve\":\"http:\\/\\/test.ihuajian.com\\/uploads\\/images\\/201801\\/bb4bce959e1.png\"},\"PropId\":1005,\"userName\":\"\",\"userId\":\"\",\"PropAmount\":1,\"avatar\":\"\",\"sex\":1}}";
		System.out.println(str.startsWith("{\"type\":6"));
	}

	private static void testOutput() {
		System.out.print("1024 \u8282\u65e5\u5feb\u4e50\uff01");
		System.out.println("\u4eac\u4e1c\u795d\u5168\u4f53\u7a0b\u5e8f\u5458\u8282\u65e5\u5feb\u4e50\uff01");
	}

	static class FaceDownLoadBean {
		public String fileUrl;

		public FaceDownLoadBean(String fileUrl) {
			super();
			this.fileUrl = fileUrl;
		}

	}
}
