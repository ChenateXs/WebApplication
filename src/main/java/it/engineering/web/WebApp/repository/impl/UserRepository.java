package it.engineering.web.WebApp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import it.engineering.web.WebApp.entity.UserEntity;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;
import it.engineering.web.WebApp.repository.IcrudRepository;

public class UserRepository implements IcrudRepository<UserEntity, Long>{

	@Override
	public void create(UserEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity read(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, UserEntity entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<UserEntity> getAll(){
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<UserEntity> users = em.createNamedQuery("User.findAll",UserEntity.class).getResultList();
		em.close();
		return users;
	}
}
