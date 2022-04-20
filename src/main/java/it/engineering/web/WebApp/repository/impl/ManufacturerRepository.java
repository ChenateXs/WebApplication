package it.engineering.web.WebApp.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.entity.City;
import it.engineering.web.WebApp.entity.Manufacturer;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;
import it.engineering.web.WebApp.repository.IcrudRepository;

public class ManufacturerRepository implements IcrudRepository<Manufacturer, Long>{

	@Override
	public void create(Manufacturer entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(entity);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Manufacturer read(Long id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		Manufacturer manufacturer = em.find(Manufacturer.class, id);
		return manufacturer;
	}

	@Override
	public void update(Long id, Manufacturer entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();
		Manufacturer existingManufacturer = em.find(Manufacturer.class, id);
		if (existingManufacturer != null) {
			em.getTransaction().begin();
			existingManufacturer.setManufactortrId(entity.getManufactortrId());
			existingManufacturer.setTaxId(entity.getTaxId());
			existingManufacturer.setAddress(entity.getAddress());
			existingManufacturer.setCity(em.find(City.class, entity.getCity().getZipCode()));
			em.getTransaction().commit();
		} else {
			throw new Exception("Manufacturer with that zip code dosen't exists");
		}
		
	}

	@Override
	public void delete(Long id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		Manufacturer manufacturer = em.find(Manufacturer.class, id);
		if (manufacturer != null)
			em.remove(manufacturer);
		else
			throw new Exception("Manufacturer with that id dosen't exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Manufacturer> getAll() {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<Manufacturer> manufacturers = em.createNamedQuery("Manufacturer.findAll",Manufacturer.class).getResultList();
		em.close();
		return manufacturers;
	}

}
