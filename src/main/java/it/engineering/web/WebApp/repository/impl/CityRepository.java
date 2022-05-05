package it.engineering.web.WebApp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.entity.CityEntity;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;
import it.engineering.web.WebApp.repository.IcrudRepository;

public class CityRepository implements IcrudRepository<CityEntity, String> {

	@Override
	public void create(CityEntity entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();

		if (em.find(CityEntity.class, entity.getZipCode()) == null)
			em.persist(entity);
		else
			throw new Exception("City with that zip code already exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public CityEntity read(String id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		return em.find(CityEntity.class, id);
	}

	@Override
	public void update(String id, CityEntity entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();
		CityEntity existingCity = em.find(CityEntity.class, id);
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
		CityEntity city = em.find(CityEntity.class, id);
		if (city != null)
			em.remove(city);
		else
			throw new Exception("City with that zip code dosen't exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<CityEntity> getAll() {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		List<CityEntity> cities = em.createNamedQuery("City.findAll", CityEntity.class).getResultList();
		em.close();
		return cities;
	}
}
