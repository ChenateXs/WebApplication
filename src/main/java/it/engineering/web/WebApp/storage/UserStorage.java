package it.engineering.web.WebApp.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.service.UserService;

public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	private UserService userService;
	
	public UserStorage() {
		userService = new UserService();
		
		users = userService.getAll();
	}
	
	public static UserStorage	getInstance() {
		if(instance == null) instance = new UserStorage();
		return instance;
	}
	
	public void add(User user) {
		users.add(user);
	}
	
	public List<User> getUsers() {
		return users;
	}
}
