package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		System.out.println(list.toString());
		handleList(list);

		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list = list2;
		handleList(list);

		List<Student> list3 = new ArrayList<>();
		list3.add(new Student("fred", 29));
		list3.get(0).age = 20;
		System.out.println(list3.get(0).toString());
	}

	public static void handleList(List<String> list) {
		System.out.println(list.size());
	}

	static class Student {
		public String name;
		public int age;

		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "姓名：" + name + ",年龄：" + age;
		}
	}
}
