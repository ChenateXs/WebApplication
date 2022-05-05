package it.engineering.web.WebApp.spring.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.engineering.web.WebApp.entity.UserEntity;
import it.engineering.web.WebApp.spring.repository.UserRepository;

@Repository
public class UserRepositoryJpaImpl implements UserRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserEntity login(UserEntity userEntity) {
		List<UserEntity> users = entityManager
				.createQuery("SELECT u FROM UserEntity u WHERE u.username=:username AND u.password=:password",UserEntity.class)
				.setParameter("username", userEntity.getUsername())
				.setParameter("password", userEntity.getPassword()).getResultList();
		
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

}
