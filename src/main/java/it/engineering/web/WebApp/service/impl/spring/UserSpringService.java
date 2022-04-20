package it.engineering.web.WebApp.service.impl.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import it.engineering.web.WebApp.config.ApplicationConfiguration;
import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.repository.IcrudRepository;
import it.engineering.web.WebApp.service.IcrudService;

@Service(value = "userSpringService")
public class UserSpringService implements IcrudService<User, Long>{
	
	@Autowired
	@Qualifier(value = "userSpringRepository")
	IcrudRepository icrudRepository;
	
	public UserSpringService() {
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
