package it.engineering.web.WebApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.repository.IcrudRepository;
import it.engineering.web.WebApp.repository.impl.UserRepository;
import it.engineering.web.WebApp.service.IcrudService;

public class UserService implements IcrudService<User, Long>{
	IcrudRepository icrudRepository;
	
	public UserService() {
		icrudRepository = new UserRepository();
	}
	
	@Override
	public void create(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User read(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Long id, User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		List<it.engineering.web.WebApp.entity.User> userEntities= icrudRepository.getAll();
		List<User> users = new ArrayList<User>();
		for(it.engineering.web.WebApp.entity.User userE:userEntities) {
			users.add(new User(userE.getId(),userE.getUsername(),userE.getPassword(),userE.getFirstname(),userE.getLastname()));
		}
		return users;
	}
	
}
