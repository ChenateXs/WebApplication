package it.engineering.web.WebApp.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.dto.UserDto;
import it.engineering.web.WebApp.service.IcrudService;
import it.engineering.web.WebApp.service.impl.UserService;

public class UserStorage{
	private List<UserDto> users;
	private static UserStorage instance;
	private IcrudService icrudService;
	
	public UserStorage(){
		icrudService = new UserService();
		
		users = icrudService.getAll();
	}
	
	public static UserStorage getInstance() {
		if(instance == null) instance = new UserStorage();
		return instance;
	}
	
	public void add(UserDto user) {
		users.add(user);
	}
	
	public List<UserDto> getUsers() {
		return users;
	}
}
