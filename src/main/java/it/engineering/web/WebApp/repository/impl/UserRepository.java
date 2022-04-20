package it.engineering.web.WebApp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import it.engineering.web.WebApp.entity.User;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;
import it.engineering.web.WebApp.repository.IcrudRepository;

public class UserRepository implements IcrudRepository<User, Long>{

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
	public List<User> getAll(){
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<User> users = em.createNamedQuery("User.findAll",User.class).getResultList();
		em.close();
		return users;
	}
}
