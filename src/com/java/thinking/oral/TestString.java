package com.java.thinking.oral;

public class TestString {
	private static String target;
	private static TestBoolean testBoolean;

	public static void main(String[] args) {
//		System.out.println(target.equals(null));
		System.out.println(testBoolean == null);
		System.out.println(cutOffEventName("com.qccr.mobile.ll.11"));
	}

	private static String cutOffEventName(String eventName) {
		int index = eventName.indexOf(".");
		if (index == -1) {
			return eventName;
		}
		index = eventName.indexOf(".", index + 1);
		if (index == -1) {
			return eventName;
		}
		index = eventName.indexOf(".", index + 1);
		if (index == -1) {
			return eventName;
		}
		return eventName.substring(index + 1);
	}
}
