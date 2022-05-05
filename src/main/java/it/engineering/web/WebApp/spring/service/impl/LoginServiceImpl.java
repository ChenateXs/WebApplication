package it.engineering.web.WebApp.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.web.WebApp.dto.UserDto;
import it.engineering.web.WebApp.entity.UserEntity;
import it.engineering.web.WebApp.spring.repository.UserRepository;
import it.engineering.web.WebApp.spring.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto login(UserDto userDto) {
		 UserEntity userEntity = userRepository.login(
				 new UserEntity(
						 userDto.getId(),
						 userDto.getUsername(),
						 userDto.getPassword(),
						 userDto.getFirstname(),
						 userDto.getLastname()));
		 
		 return new UserDto(
				 userEntity.getId(),
				 userEntity.getUsername(),
				 userEntity.getPassword(),
				 userEntity.getFirstname(),
				 userEntity.getLastname()
				 );
	}

}
