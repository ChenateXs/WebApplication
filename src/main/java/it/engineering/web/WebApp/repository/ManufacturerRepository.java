package it.engineering.web.WebApp.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.persistence.MyEntitnyManagerFactory;

public class ManufacturerRepository implements ICRUDRepository<Manufacturer, BigInteger>{

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
	public Manufacturer read(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BigInteger id, Manufacturer entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manufacturer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
