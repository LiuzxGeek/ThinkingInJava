package com.java.thinking.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TestList {
	static Student student;

	public static void main(String[] args) {
		test4();
	}

	private static void test4() {
		List<Student> list = new ArrayList<>(4);
//		list.add(null);
//		list.add(null);
//		list.add(null);
//		list.add(null);
		list.add(1, new Student("1", 1));
		list.add(2, new Student("2", 2));
		list.add(0, new Student("0", 0));
		list.add(3, new Student("3", 3));
		for (Iterator<Student> iterator = list.iterator(); iterator.hasNext();) {
			Student string = iterator.next();
			if (string!=null) {
				System.out.println(string.toString());				
			}
		}
		System.out.println(list.size());
	}

	private static void test3() {
		List<Student> list3 = new ArrayList<>();
		student = new Student("fred", 29);
		list3.add(student);
		list3.get(0).age = 20;
		System.out.println(list3.get(0).toString());
		Timer timer = new Timer();
		final Student exp = list3.get(0);
		list3.remove(0);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(exp.toString());
				System.out.println(student.toString());
			}
		}, 1000);
		student = null;
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
