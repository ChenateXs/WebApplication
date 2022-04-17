package it.engineering.web.WebApp.service;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.domain.Manufacturer;
import it.engineering.web.WebApp.repository.ManufacturerRepository;

public class ManufacturerService implements ICRUDService<Manufacturer, Long>{

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
	public Manufacturer read(Long id) throws Exception {
		it.engineering.web.WebApp.entity.Manufacturer manufacturer = manufacturerRepository.read(id);
		return new Manufacturer(
				manufacturer.getId(),
				manufacturer.getManufactortrId(),
				manufacturer.getTaxId(),
				manufacturer.getAddress(),
				new City(manufacturer.getCity().getZipCode(),manufacturer.getCity().getName()));
	}

	@Override
	public void update(Long id, Manufacturer entity) throws Exception {
		manufacturerRepository.update(id, new
				it.engineering.web.WebApp.entity.Manufacturer(
						entity.getId(),
						entity.getManufactortrId(),
						entity.getTaxId(),
						entity.getAddress(),
						new it.engineering.web.WebApp.entity.City(entity.getCity().getZipCode(),entity.getCity().getName())));	
	}

	@Override
	public void delete(Long id) throws Exception {
		manufacturerRepository.delete(id);	
	}

	@Override
	public List<Manufacturer> getAll() {
		List<it.engineering.web.WebApp.entity.Manufacturer> manufacturerEntities= manufacturerRepository.getAll();
		List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		for(it.engineering.web.WebApp.entity.Manufacturer manufacturerE:manufacturerEntities) {
			manufacturers.add(new Manufacturer(
					manufacturerE.getId(),
					manufacturerE.getManufactortrId(), 
					manufacturerE.getTaxId(), 
					manufacturerE.getAddress(), 
					new City(manufacturerE.getCity().getZipCode(), manufacturerE.getCity().getName())));
		}
		return manufacturers;
	}

}
