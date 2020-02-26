package com.java.thinking.saas;

/*
*@author:liuxian
*@date:2019年6月18日
*/
public class ShowUser {
	public static void main(String[] args) {
		User user = new User(1, "李三", "123455");
		System.out.println("保存李三信息：" + UserDao.saveUser(user));
		User wang = UserDao.getUser(2);
		System.out.println("查询王二信息：" + (wang != null ? "已找到" : "未找到"));
		User li = UserDao.getUser(1);
		System.out.println("查询李三信息：" + (li != null ? "已找到" : "未找到"));
	}
}
