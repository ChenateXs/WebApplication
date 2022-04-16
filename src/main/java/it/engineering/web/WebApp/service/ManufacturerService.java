package it.engineering.web.WebApp.service;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.repository.ManufacturerRepository;

public class ManufacturerService implements ICRUDService<Manufacturer, String>{

	ManufacturerRepository manufacturerRepository;
	
	public ManufacturerService() {
		manufacturerRepository = new ManufacturerRepository();
	}
	
	@Override
	public void create(Manufacturer entity) throws Exception {
		it.engineering.web.WebApp.entity.Manufacturer manufacturer = 
				new it.engineering.web.WebApp.entity.Manufacturer(
						entity.getManufactortrId(),
						entity.getTaxId(),
						entity.getAddress(),
						new it.engineering.web.WebApp.entity.City(entity.getCity().getZipCode(),entity.getCity().getName()));
		manufacturerRepository.create(manufacturer);
	}

	@Override
	public Manufacturer read(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String id, Manufacturer entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manufacturer> getAll() {
		List<it.engineering.web.WebApp.entity.Manufacturer> manufacturerEntities= manufacturerRepository.getAll();
		List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		for(it.engineering.web.WebApp.entity.Manufacturer manufactureryE:manufacturerEntities) {
			manufacturers.add(new Manufacturer(manufactureryE.getManufactortrId(), manufactureryE.getTaxId(), manufactureryE.getAddress(), new City(manufactureryE.getCity().getZipCode(), manufactureryE.getCity().getName())));
		}
		return manufacturers;
	}

}
