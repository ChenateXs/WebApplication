package it.engineering.web.WebApp.service;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.WebApp.domain.City;
import it.engineering.web.WebApp.repository.CityRepository;

public class CityService implements ICRUDService<City, String>{
	CityRepository cityRepository;
	
	public CityService() {
		cityRepository = new CityRepository();
	}
	
	@Override
	public void create(City entity) throws Exception {
		it.engineering.web.WebApp.entity.City cityE = new it.engineering.web.WebApp.entity.City(entity.getZipCode(), entity.getName());
		cityRepository.create(cityE);
		
	}

	@Override
	public City read(String id) throws Exception {
		it.engineering.web.WebApp.entity.City cityE = cityRepository.read(id);
		return new City(cityE.getZipCode(),cityE.getName());
	}

	@Override
	public void update(String id, City entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) throws Exception {
		cityRepository.delete(id);
	}

	@Override
	public List<City> getAll() {
		List<it.engineering.web.WebApp.entity.City> cityEntities= cityRepository.getAll();
		List<City> cities = new ArrayList<City>();
		for(it.engineering.web.WebApp.entity.City cityE:cityEntities) {
			cities.add(new City(cityE.getZipCode(),cityE.getName()));
		}
		return cities;
	}

}
