package it.engineering.web.WebApp.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.domain.User;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;

public class CityRepository implements ICRUDRepository<City,BigInteger> {

	@Override
	public void create(City entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		
		if(!exist(entity,em))
			em.persist(entity);
		else 
			throw new Exception("City with that zip code already exists");
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public City read(BigInteger id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		return  em.find(City.class, id);
	}

	@Override
	public void update(BigInteger id, City entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BigInteger id) throws Exception  {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<City> getAll() {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<City> cities = em.createNamedQuery("City.findAll",City.class).getResultList();
		em.close();
		return cities;
	}

	private boolean exist(City entity, EntityManager em) {
		return em.find(City.class, entity.getZipCode())!=null;
	}
}
