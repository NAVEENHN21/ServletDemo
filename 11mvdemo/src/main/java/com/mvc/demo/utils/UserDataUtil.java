package com.mvc.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.mvc.demo.model.User;

public class UserDataUtil {

	public static List<User> getUsers(){
		
		List<User> users=new ArrayList<>();
		users.add(new User("navi","hn","navi@gmail.com","123"));
		users.add(new User("suman","hn","navi@gmail.com","123"));
		users.add(new User("anu","hn","navi@gmail.com","123"));
		users.add(new User("child","hn","navi@gmail.com","123"));

		return users;
	}
}
