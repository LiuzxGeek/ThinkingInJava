package com.java.thinking.entity;

/*
*@author:liuxian
*@date:2019年5月19日
*/
public class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
