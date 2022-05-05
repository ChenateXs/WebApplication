package it.engineering.web.WebApp.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.entity.CityEntity;
import it.engineering.web.WebApp.entity.ManufacturerEntity;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;
import it.engineering.web.WebApp.repository.IcrudRepository;

public class ManufacturerRepository implements IcrudRepository<ManufacturerEntity, Long>{

	@Override
	public void create(ManufacturerEntity entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(entity);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public ManufacturerEntity read(Long id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		ManufacturerEntity manufacturer = em.find(ManufacturerEntity.class, id);
		return manufacturer;
	}

	@Override
	public void update(Long id, ManufacturerEntity entity) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();
		ManufacturerEntity existingManufacturer = em.find(ManufacturerEntity.class, id);
		if (existingManufacturer != null) {
			em.getTransaction().begin();
			existingManufacturer.setManufactortrId(entity.getManufactortrId());
			existingManufacturer.setTaxId(entity.getTaxId());
			existingManufacturer.setAddress(entity.getAddress());
			existingManufacturer.setCity(em.find(CityEntity.class, entity.getCity().getZipCode()));
			em.getTransaction().commit();
		} else {
			throw new Exception("Manufacturer with that zip code dosen't exists");
		}
		
	}

	@Override
	public void delete(Long id) throws Exception {
		EntityManager em = MyEntitnyManagerFactory.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		ManufacturerEntity manufacturer = em.find(ManufacturerEntity.class, id);
		if (manufacturer != null)
			em.remove(manufacturer);
		else
			throw new Exception("Manufacturer with that id dosen't exists");

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<ManufacturerEntity> getAll() {
		EntityManager em = MyEntitnyManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();

		List<ManufacturerEntity> manufacturers = em.createNamedQuery("Manufacturer.findAll",ManufacturerEntity.class).getResultList();
		em.close();
		return manufacturers;
	}

}
