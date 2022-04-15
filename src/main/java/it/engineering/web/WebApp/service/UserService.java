package it.engineering.web.WebApp.service;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.repository.UserRepository;

public class UserService implements ICRUDService<User, String>{
	UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	@Override
	public void create(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String id, User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		List<it.engineering.web.WebApp.entity.User> userEntities= userRepository.getAll();
		List<User> users = new ArrayList<User>();
		for(it.engineering.web.WebApp.entity.User userE:userEntities) {
			users.add(new User(userE.getId(),userE.getUsername(),userE.getPassword(),userE.getFirstname(),userE.getLastname()));
		}
		return users;
	}

}
