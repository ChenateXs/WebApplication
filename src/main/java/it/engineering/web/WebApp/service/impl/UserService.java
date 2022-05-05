package it.engineering.web.WebApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.engineering.web.WebApp.dto.UserDto;
import it.engineering.web.WebApp.repository.IcrudRepository;
import it.engineering.web.WebApp.repository.impl.UserRepository;
import it.engineering.web.WebApp.service.IcrudService;

public class UserService implements IcrudService<UserDto, Long>{
	IcrudRepository icrudRepository;
	
	public UserService() {
		icrudRepository = new UserRepository();
	}
	
	@Override
	public void create(UserDto entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UserDto read(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Long id, UserDto entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDto> getAll() {
		List<it.engineering.web.WebApp.entity.UserEntity> userEntities= icrudRepository.getAll();
		List<UserDto> users = new ArrayList<UserDto>();
		for(it.engineering.web.WebApp.entity.UserEntity userE:userEntities) {
			users.add(new UserDto(userE.getId(),userE.getUsername(),userE.getPassword(),userE.getFirstname(),userE.getLastname()));
		}
		return users;
	}
	
}
