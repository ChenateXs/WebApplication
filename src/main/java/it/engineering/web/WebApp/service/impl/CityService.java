package it.engineering.web.WebApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.dto.CityDto;
import it.engineering.web.WebApp.repository.impl.CityRepository;
import it.engineering.web.WebApp.service.IcrudService;

public class CityService implements IcrudService<CityDto, String>{
	CityRepository cityRepository;
	
	public CityService() {
		cityRepository = new CityRepository();
	}
	
	@Override
	public void create(CityDto entity) throws Exception {
		it.engineering.web.WebApp.entity.CityEntity cityE = new it.engineering.web.WebApp.entity.CityEntity(entity.getZipCode(), entity.getName());
		cityRepository.create(cityE);
		
	}

	@Override
	public CityDto read(String id) throws Exception {
		it.engineering.web.WebApp.entity.CityEntity cityE = cityRepository.read(id);
		return new CityDto(cityE.getZipCode(),cityE.getName());
	}

	@Override
	public void update(String id, CityDto entity) throws Exception {
		it.engineering.web.WebApp.entity.CityEntity city = new it.engineering.web.WebApp.entity.CityEntity(entity.getZipCode(),entity.getName());
		
		cityRepository.update(id,city);
	}

	@Override
	public void delete(String id) throws Exception {
		cityRepository.delete(id);
	}

	@Override
	public List<CityDto> getAll() {
		List<it.engineering.web.WebApp.entity.CityEntity> cityEntities= cityRepository.getAll();
		List<CityDto> cities = new ArrayList<CityDto>();
		for(it.engineering.web.WebApp.entity.CityEntity cityE:cityEntities) {
			cities.add(new CityDto(cityE.getZipCode(),cityE.getName()));
		}
		return cities;
	}

}
