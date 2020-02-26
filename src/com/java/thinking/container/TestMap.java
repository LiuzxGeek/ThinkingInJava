package com.java.thinking.container;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String, Student> map = new HashMap<>(1);
//		System.out.println(map.get("1") == null);
		map.put("2", null);
		System.out.println("map大小：" + map.size());
//		map.put("3", null);
//		System.out.println("map大小：" + map.size());
		int count = 5;
		Student student = new Student(5);
		map.put("6", student);
		student.setAge(7);
		System.out.println("6号小孩子几岁：" + map.get("6").getAge());
		while (true) {
			if (count == 0)
				break;
			if (count % 2 == 0) {
				count--;
				continue;
			}
			System.out.println(count);
			count--;
		}
	}

	static class Student {
		private int age;

		public Student(int age) {
			super();
			this.age = age;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	};
}
