package it.engineering.web.WebApp.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.entity.City;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;

public class CityRepository implements ICRUDRepository<City, String> {

	@Override
	public void create(City entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();

		if (em.find(City.class, entity.getZipCode()) == null)
			em.persist(entity);
		else
			throw new Exception("City with that zip code already exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public City read(String id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		return em.find(City.class, id);
	}

	@Override
	public void update(String id, City entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();
		City existingCity = em.find(City.class, id);
		if (existingCity != null) {
			em.getTransaction().begin();
			existingCity.setZipCode(entity.getZipCode());
			existingCity.setName(entity.getName());
			em.getTransaction().commit();
		} else {
			throw new Exception("City with that zip code dosen't exists");
		}

	}

	@Override
	public void delete(String id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		City city = em.find(City.class, id);
		if (city != null)
			em.remove(city);
		else
			throw new Exception("City with that zip code dosen't exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<City> getAll() {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		List<City> cities = em.createNamedQuery("City.findAll", City.class).getResultList();
		em.close();
		return cities;
	}
}
