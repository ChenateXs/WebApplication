package it.engineering.web.WebApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.dto.CityDto;
import it.engineering.web.WebApp.dto.ManufacturerDto;
import it.engineering.web.WebApp.repository.impl.ManufacturerRepository;
import it.engineering.web.WebApp.service.IcrudService;

public class ManufacturerService implements IcrudService<ManufacturerDto, Long>{

	ManufacturerRepository manufacturerRepository;
	
	public ManufacturerService() {
		manufacturerRepository = new ManufacturerRepository();
	}
	
	@Override
	public void create(ManufacturerDto entity) throws Exception {
		it.engineering.web.WebApp.entity.ManufacturerEntity manufacturer = 
				new it.engineering.web.WebApp.entity.ManufacturerEntity(
						entity.getManufactortrId(),
						entity.getTaxId(),
						entity.getAddress(),
						new it.engineering.web.WebApp.entity.CityEntity(entity.getCity().getZipCode(),entity.getCity().getName()));
		manufacturerRepository.create(manufacturer);
	}

	@Override
	public ManufacturerDto read(Long id) throws Exception {
		it.engineering.web.WebApp.entity.ManufacturerEntity manufacturer = manufacturerRepository.read(id);
		return new ManufacturerDto(
				manufacturer.getId(),
				manufacturer.getManufactortrId(),
				manufacturer.getTaxId(),
				manufacturer.getAddress(),
				new CityDto(manufacturer.getCity().getZipCode(),manufacturer.getCity().getName()));
	}

	@Override
	public void update(Long id, ManufacturerDto entity) throws Exception {
		manufacturerRepository.update(id, new
				it.engineering.web.WebApp.entity.ManufacturerEntity(
						entity.getId(),
						entity.getManufactortrId(),
						entity.getTaxId(),
						entity.getAddress(),
						new it.engineering.web.WebApp.entity.CityEntity(entity.getCity().getZipCode(),entity.getCity().getName())));	
	}

	@Override
	public void delete(Long id) throws Exception {
		manufacturerRepository.delete(id);	
	}

	@Override
	public List<ManufacturerDto> getAll() {
		List<it.engineering.web.WebApp.entity.ManufacturerEntity> manufacturerEntities= manufacturerRepository.getAll();
		List<ManufacturerDto> manufacturers = new ArrayList<ManufacturerDto>();
		for(it.engineering.web.WebApp.entity.ManufacturerEntity manufacturerE:manufacturerEntities) {
			manufacturers.add(new ManufacturerDto(
					manufacturerE.getId(),
					manufacturerE.getManufactortrId(), 
					manufacturerE.getTaxId(), 
					manufacturerE.getAddress(), 
					new CityDto(manufacturerE.getCity().getZipCode(), manufacturerE.getCity().getName())));
		}
		return manufacturers;
	}

}
