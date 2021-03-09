package com.java.thinking.data;

public class TestMemory {
	public static String get(int size) {
		int count = 0;
		while (size > 1024) {
			size = size(size);
			count++;
		}
		switch (count) {
		case 0:
			return size + "Byte";
		case 1:

			return size + "KB";
		case 2:

			return size + "M";
		case 3:

			return size + "G";

		default:
			break;
		}
		return "";
	}

	static int size(int size) {
		if (size > 1024) {
			size = size / 1024;
		}
		return size;
	}

	public static void main(String[] args) {
		System.out.println(get(8388608));
	}
}
