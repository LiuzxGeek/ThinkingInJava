package com.java.thinking.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
*@author:liuxian
*@date:2018年5月28日
*/
public class TestAnnotation {

	@Comment("hello,field")
	private String field;

	@Comment("hello,constructor")
	public TestAnnotation(String field) {
		super();
		this.field = field;
	}

	@Comment("hello,class")
	public class InnerClass {

	}

	@Comment("hello,method")
	private static void testMethod() {
		try {
			// 获取要解析的类
			Class<?> cls = Class.forName(TestAnnotation.class.getName());
			// 拿到所有Field
			Method[] declareds = cls.getDeclaredMethods();
			for (Method field : declareds) {
				// 获取Field上的注解
				Comment annotation = field.getAnnotation(Comment.class);
				if (annotation != null) {
					// 获取注解值
					String value = annotation.value();
					System.out.println(value);
				}

			}
		} catch (ClassNotFoundException e) {
			if (e != null)
				System.out.println("Error:" + e.getMessage());
		}
	}

	private static void testField() {
		try {
			// 获取要解析的类
			Class<?> cls = Class.forName(TestAnnotation.class.getName());
			// 拿到所有Field
			Field[] declareds = cls.getDeclaredFields();
			for (Field field : declareds) {
				// 获取Field上的注解
				Comment annotation = field.getAnnotation(Comment.class);
				if (annotation != null) {
					// 获取注解值
					String value = annotation.value();
					System.out.println(value);
				}

			}
		} catch (ClassNotFoundException e) {
			if (e != null)
				System.out.println("Error:" + e.getMessage());
		}
	}

	private static void testConstructor() {
		try {
			// 获取要解析的类
			Class<?> cls = Class.forName(TestAnnotation.class.getName());
			// 拿到所有Field
			Constructor<?>[] declareds = cls.getDeclaredConstructors();
			for (Constructor<?> field : declareds) {
				// 获取Field上的注解
				Comment annotation = field.getAnnotation(Comment.class);
				if (annotation != null) {
					// 获取注解值
					String value = annotation.value();
					System.out.println(value);
				}

			}
		} catch (ClassNotFoundException e) {
			if (e != null)
				System.out.println("Error:" + e.getMessage());
		}
	}

	private static void testClass() {
		try {
			// 获取要解析的类
			Class<?> cls = Class.forName(TestAnnotation.class.getName());
			// 拿到所有Field
			Class<?>[] declareds = cls.getDeclaredClasses();
			for (Class<?> field : declareds) {
				// 获取Field上的注解
				Comment annotation = field.getAnnotation(Comment.class);
				if (annotation != null) {
					// 获取注解值
					String value = annotation.value();
					System.out.println(value);
				}

			}
		} catch (ClassNotFoundException e) {
			if (e != null)
				System.out.println("Error:" + e.getMessage());
		}
	}

	private static void testAnnotation() {
		try {
			// 获取要解析的类
			Class<?> cls = Class.forName(TestAnnotation.class.getName());
			// 拿到所有Field
			Annotation annotationConstructor = cls.getDeclaredConstructors()[0].getAnnotations()[0];
			printAnnotation(annotationConstructor);

			Annotation fieldConstructor = cls.getDeclaredFields()[0].getAnnotations()[0];
			printAnnotation(fieldConstructor);

			Annotation clzConstructor = cls.getDeclaredClasses()[0].getAnnotations()[0];
			printAnnotation(clzConstructor);

		} catch (ClassNotFoundException e) {
			if (e != null)
				System.out.println("Error:" + e.getMessage());
		}
	}

	private static void printAnnotation(Annotation annotation) {
		// 获取注解值
		String value = ((Comment) annotation).value();
		System.out.println(value);
	}

	public static void main(String[] args) {
		testMethod();
		testField();
		testClass();
		testConstructor();
		
		System.out.println("Annotation:");
		
		testAnnotation();
	}
}