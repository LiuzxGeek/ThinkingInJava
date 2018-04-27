package com.java.thinking.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*@author:liuxian
*@date:2018年4月13日
*/
public class TestComparable {
	static class Student {
		public int age;
		public String name;

		public Student(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + "\t" + age + "岁";
		}
	}

	static class Teacher implements Comparable<Teacher> {
		public int age;
		public String name;

		public Teacher(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + "\t" + age + "岁";
		}

		@Override
		public int compareTo(Teacher teacher) {
			// TODO Auto-generated method stub
			if (this.age > teacher.age) {
				return 1;
			}
			if (this.age < teacher.age) {
				return -1;
			}
			return 0;
		}
	}

	private static void testStudent() {
		System.out.println("testStudent");
		List<Student> list = new ArrayList<>();
		list.add(new Student(18, "A"));
		list.add(new Student(11, "B"));
		list.add(new Student(18, "C"));
		list.add(new Student(19, "D"));
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if (o1.age > o2.age) {
					return 1;
				} else if (o1.age < o2.age) {
					return -1;
				}
				return 0;
			}
		});
		list.forEach(stu -> {
			System.out.println(stu.toString());
		});
	}

	private static void testArray() {
		System.out.println("testArray");
		String[] array = { "BB", "CC", "AA" };
		Arrays.sort(array);
		for (String str : array) {
			System.out.println(str);
		}
	}

	private static void testTeacher() {
		System.out.println("testTeacherList");
		List<Teacher> list = new ArrayList<>();
		Teacher a = new Teacher(118, "AA");
		list.add(a);
		Teacher c = new Teacher(119, "CC");
		list.add(c);
		Teacher b = new Teacher(111, "BB");
		list.add(b);

		Collections.sort(list);

		System.out.println("a 大于 b:" + (a.compareTo(b) == 1));

		list.forEach(stu -> {
			System.out.println(stu.toString());
		});
	}

	public static void main(String[] args) {
		testStudent();
		testArray();
		testTeacher();
	}
}
