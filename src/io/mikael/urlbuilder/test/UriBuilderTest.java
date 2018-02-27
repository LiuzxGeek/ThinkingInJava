package io.mikael.urlbuilder.test;

import io.mikael.urlbuilder.UrlBuilder;

public class UriBuilderTest {
	public static void main(String[] args) {
		String str1 = UrlBuilder.fromString("http://www.google.com/abc?a=b").addParameter("q", "charlie brown").toString();
		String str2 = UrlBuilder.fromString("http://foo/h%F6pl%E4", "ISO-8859-1").encodeAs("UTF-8").toString();
		System.out.println(str1);
		System.out.println(str2);
		final UrlBuilder ub1 = UrlBuilder.empty().withScheme("http").withHost("www.example.com").withPath("/")
				.addParameter("foo", "bar");
		System.out.println(ub1.toString());
		final java.net.URI uri1 = ub1.toUri();

		try {
			final java.net.URI uri2 = ub1.toUriWithException();
		} catch (java.net.URISyntaxException ex) {
			// handle the exception
		}

		final java.net.URL url1 = ub1.toUrl();

		try {
			final java.net.URL url2 = ub1.toUrlWithException();
		} catch (java.net.MalformedURLException ex) {
			// handle the exception
		}
	}
}
