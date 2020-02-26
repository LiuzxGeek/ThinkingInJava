package com.java.thinking.url;

import java.net.URI;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@author:liuxian
*@date:2019年6月4日
*/
public class TestUrl {
	private static String getNameBySplit(String url) {
		String[] attr = url.split("/");
		String nameParam = attr[attr.length - 1];
		String[] param = nameParam.split("\\?");
		String[] nameType = param[0].split("\\.");
		return nameType[0];
	}

	private static String getNameByUri(String url) {
		URI uri = URI.create(url);
		System.out.println(uri.getPath());
		System.out.println(uri.getQuery());
		return url;
	}

	private static void printTiktok() {
		String str = "<div style=\"background-image:url(&quot;https://p16.muscdn.com/img/musically-maliva-obj/1634016763527174~c5_100x100.jpeg&quot;);border-radius:;width:64px;height:64px;flex:0 0 64px\" class=\"jsx-2729494178 jsx-2396121741 avatar-wrapper round\"></div>";
		String regex = "(?i)https://[^\u4e00-\u9fa5]+.jpeg";
		regex = "(?<=\\().*?(?=\\))";
		Matcher m = Pattern.compile(regex).matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	private static void parseTiktok() {
		String str = "<div style=\"background-image:url(&quot;data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB3aWR0aD0iNDAiIGhlaWdodD0iNDAiIHZpZXdCb3g9IjAgMCA0MCA0MCI+CiAgICA8ZGVmcz4KICAgICAgICA8cGF0aCBpZD0iYiIgZD0iTTIzLjE3MiAxNC43MzRjLjI3Ni4zMDYuNDc3LjU0Mi42LjcwNkE3LjU1NyA3LjU1NyAwIDAgMSAyNS4zMDcgMjBhNy41NiA3LjU2IDAgMCAxLTEuNTc3IDQuNjE1Yy0uMTE2LjE1MS0uMzAyLjM2OC0uNTU4LjY1MWwtMS40MTctMS4yM2MuMjA5LS4yMy4zNi0uNDA2LjQ1My0uNTNBNS44IDUuOCAwIDAgMCAyMy4zODMgMjBhNS43OSA1Ljc5IDAgMCAwLTEuMTA2LTMuNDA2IDguODY5IDguODY5IDAgMCAwLS41MjItLjYzbDEuNDE3LTEuMjN6bTIuMzY4LTIuMDU4Yy4yOTYuMzI2LjUxMi41NzUuNjQ5Ljc0N0MyNy42MzkgMTUuMjUgMjguNSAxNy41MjUgMjguNSAyMGMwIDIuNDg1LS44NjcgNC43NjYtMi4zMjggNi41OTgtLjEzMy4xNjctLjM0NC40MS0uNjMyLjcyNmwtMS40MTctMS4yM2MuMjUtLjI3My40MzItLjQ4Mi41NDYtLjYyNkE4LjczNSA4LjczNSAwIDAgMCAyNi41OTcgMjBjMC0yLjA1LS43My0zLjk0NC0xLjkzMi01LjQ2N2ExMy43NjMgMTMuNzYzIDAgMCAwLS41NDItLjYyNmwxLjQxNy0xLjIzMXpNMTAuNzUyIDIyLjg5YS43NDcuNzQ3IDAgMCAxLS43NTItLjc1NXYtNC4yNjljMC0uNDE3LjM0MS0uNzU1Ljc1Mi0uNzU1SDE0bDMuNTU0LTMuNDIzYy43OTktLjc3IDEuNDQ2LS40OTggMS40NDYuNjA2djExLjQxM2MwIDEuMTA1LS42NDMgMS4zOC0xLjQ0Ni42MDZMMTQgMjIuODloLTMuMjQ4eiIvPgogICAgICAgIDxmaWx0ZXIgaWQ9ImEiIHdpZHRoPSIyMDIuNyUiIGhlaWdodD0iMjM5LjYlIiB4PSItNTEuNCUiIHk9Ii02Mi43JSIgZmlsdGVyVW5pdHM9Im9iamVjdEJvdW5kaW5nQm94Ij4KICAgICAgICAgICAgPGZlT2Zmc2V0IGR5PSIxIiBpbj0iU291cmNlQWxwaGEiIHJlc3VsdD0ic2hhZG93T2Zmc2V0T3V0ZXIxIi8+CiAgICAgICAgICAgIDxmZUdhdXNzaWFuQmx1ciBpbj0ic2hhZG93T2Zmc2V0T3V0ZXIxIiByZXN1bHQ9InNoYWRvd0JsdXJPdXRlcjEiIHN0ZERldmlhdGlvbj0iMyIvPgogICAgICAgICAgICA8ZmVDb2xvck1hdHJpeCBpbj0ic2hhZG93Qmx1ck91dGVyMSIgdmFsdWVzPSIwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwLjIgMCIvPgogICAgICAgIDwvZmlsdGVyPgogICAgPC9kZWZzPgogICAgPGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8Y2lyY2xlIGN4PSIyMCIgY3k9IjIwIiByPSIyMCIgZmlsbD0iIzAwMCIgZmlsbC1vcGFjaXR5PSIuNSIvPgogICAgICAgIDx1c2UgZmlsbD0iIzAwMCIgZmlsdGVyPSJ1cmwoI2EpIiB4bGluazpocmVmPSIjYiIvPgogICAgICAgIDx1c2UgZmlsbD0iI0ZGRiIgeGxpbms6aHJlZj0iI2IiLz4KICAgIDwvZz4KPC9zdmc+Cg==&quot;)\" class=\"jsx-3032043364 mute-icon\"></div>";
		String regex = "(?<=\\(&quot;).*?(?=&quot;\\))";
		Matcher m = Pattern.compile(regex).matcher(str);
		String cover = "";
		while (m.find()) {
			String result = m.group().replace("data:image/svg+xml;base64,", "");
			System.out.println(result);
		}
	}

	private static void matchUrl() {
		String s = "#在抖音，记录美好生活# 用没有意见来表达意见，这才是中国人高度的艺术 #曾仕强教授 #三国  http://v.douyin.com/9r2S2L/ 复制此链接，打开【抖音短视频】，直接观看视频！";
		Matcher m = Pattern.compile("(?i)http://[^\u4e00-\u9fa5]+").matcher(s);
		while (m.find()) {
			System.out.println(m.group());
		}
		String regEx_html = "<[^>]+>";
		String str = "<font color=\"#FFFFFF\">恭喜 </font><font color=\"#FFFF56\"> 主播昵称最... </font><font color=\"#FFFFFF\">\n获得冠军</font>";
		Matcher html = Pattern.compile(regEx_html).matcher(str);
		System.out.println(html.find());
	}

	private static void match2Char() {
		// String filetext = "#戰疫在一起 杜家兄妹：堅守一綫 讓我來";
		// Pattern p = Pattern.compile("\\#(.*?) ");// 正则表达式，取=和|之间的字符串，不包括=和|
		String filetext = "url('https\\3a //scontent-hkt1-1.xx.fbcdn.net/v/t1.0-1/cp0/e15/q65/p120x120/87173059_112600916999854_1838879033622790144_n.jpg?_nc_cat\\3d 107\\26 efg\\3d eyJpIjoidCJ9\\26 _nc_ohc\\3d s3OCJyDZ_FQAX-C5Ae-\\26 _nc_ht\\3d scontent-hkt1-1.xx\\26 _nc_tp\\3d 3\\26 oh\\3d 1b1314ddb3013ce645b8d1b993b8fc66\\26 oe\\3d 5EC057E5')";
		Pattern p = Pattern.compile("url\\('(.*?)'\\)");
		Matcher m = p.matcher(filetext);
		while (m.find()) {
			System.out.println(m.group(0));// m.group(1)不包括这两个字符
			System.out.println(URLDecoder.decode(m.group(1).replace("\\", "%").replace(" ", "")));
		}
		System.out.println("https://www.facebook.com/permalink.php?story_fbid=134894518010512&id=100044698936647".equals("https://www.facebook.com/permalink.php?story_fbid=134894518010512&id=100044698936647"));
	}

	private static void testFacebook() {
		String mUrl = "https://m.facebook.com/100047498391394/posts/112698863656726/?sfnsn=mo";
		String bUrl = "https://www.facebook.com/100047498391394/posts/112698863656726/?sfnsn=mo";
		System.out.println(mUrl.substring(mUrl.indexOf(".")));
		System.out.println(bUrl.substring(bUrl.indexOf(".")));
	}

	public static void main(String[] args) {
		// String url =
		// "https://xihu-beta.unimedia.com/app/post/detail/5a151ba78e1c3a5124fd7b1a.jpg?env=android&memberID=59dad01f8e1c3a4a13dc8fc7";
		// System.out.println(getNameBySplit(url));
		// System.out.println(getNameByUri(url));
		// matchUrl();
		// printTiktok();
		// parseTiktok();
		match2Char();
		// testFacebook();
	}
}
