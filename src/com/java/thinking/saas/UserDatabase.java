package com.java.thinking.saas;

import java.util.ArrayList;
import java.util.List;

/*
*@author:liuxian
*@date:2019年6月18日
*/
public class UserDatabase {

	private static List<User> list = new ArrayList<>();

	public static User getUser(int id) {
		for (User user : list) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public static boolean saveUser(User user) {
		return list.add(user);
	}
}
