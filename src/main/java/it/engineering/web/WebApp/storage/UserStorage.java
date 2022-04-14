package it.engineering.web.WebApp.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.action.domain.User;

public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	
	public UserStorage() {
		
		users = new ArrayList<User>();
		users.add(new User("admin","admin","Admin","Admin"));
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
