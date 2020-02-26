package com.java.thinking.gc;

import java.util.ArrayList;
import java.util.List;

import com.java.thinking.entity.Student;

/*
*@author:liuxian
*@date:2019年5月19日
*/
public class TestEntity {
	private static TestEntity entity;
	public static void main(String[] args) {
		Student student = new Student("jim", 14);
		List<Student> list = new ArrayList<>();
		list.add(student);
		student.setName("tom");
		Student student2 = student;
		student = null;
		System.out.println(list.get(0).getName());
		System.out.println(student2.getName());
	}
	
}
