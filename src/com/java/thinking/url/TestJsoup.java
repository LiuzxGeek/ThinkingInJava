package com.java.thinking.url;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
*@author:liuxian
*@date:2019年9月21日
*/
public class TestJsoup {

	private static void parseInsgram(String insUrl) {
		try {
			Document doc = Jsoup.connect(insUrl).get();
			Element head = doc.head();
			Elements elements = head.select("meta");
			for (Element element : elements) {
				if (element.attr("property").equals("og:video")) {
					String linkHref = element.attr("content");
					System.out.println("og:video:" + linkHref);
				} else if (element.attr("property").equals("instapp:owner_user_id")) {
					String userId = element.attr("content");
					System.out.println("owner_user_id:" + userId);
				} else if (element.attr("property").equals("og:title")) {
					String[] title = element.attr("content").split(":");
					if (title.length > 1) {
						String content = title[1];
						System.out.println("content:" + content);
					}
				}
			}
			Element body = doc.body();
			Elements bodyElements = body.select("img[class=_6q-tv]");
			if (bodyElements.size() > 0) {
				String avatar = bodyElements.get(0).attr("src");
				System.out.println("avatar:" + avatar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void parseScript() {
		String script = "var player_data={\"flag\":\"play\",\"encrypt\":0,\"trysee\":0,\"points\":0,\"link\":\"\\/15yc_play\\/36067-1-1.html\",\"link_next\":\"\\/15yc_play\\/36067-1-2.html\",\"link_pre\":\"\",\"url\":\"https:\\/\\/yunbox.poorli.com\\/mp4hls\\/m3u8\\/zhongguojichangv3.m3u8\",\"url_next\":\"https:\\/\\/www.7639616.com\\/hls\\/20191008\\/1a9119f38a09fa50fad79a564bb61145\\/1570522437\\/index.m3u8\",\"from\":\"mingri\",\"server\":\"no\",\"note\":\"\"}";
		String pattern = "var player_data=\\{(.*?)\\}";
		// Pattern.MULTILINE 好像没有什么用，所以才使用上面的replace
		Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);
		Matcher m = r.matcher(script);
		if (m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
		}
	}

	public static void main(String[] args) {
		//parseInsgram("https://www.instagram.com/p/B2lY8s9ggce/?igshid=1y1nkat9jjmx6");
		parseScript();
	}

}
