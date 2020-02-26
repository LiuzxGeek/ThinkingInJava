package com.java.thinking.saas;

/*
*@author:liuxian
*@date:2019年6月18日
*/
public class UserDao {
	
	
	public static User getUser(int id) {
		return UserDatabase.getUser(id);
	}

	
	public static boolean saveUser(User user) {
		return UserDatabase.saveUser(user);
	}
}
