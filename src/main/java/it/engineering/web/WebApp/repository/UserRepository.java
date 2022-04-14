package it.engineering.web.WebApp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.action.domain.User;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;

public class UserRepository {
	public List<User> getAll(){
		
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<User> users = em.createNamedQuery("User.findAll",User.class).getResultList();
		em.close();
		return users;
	}
}
