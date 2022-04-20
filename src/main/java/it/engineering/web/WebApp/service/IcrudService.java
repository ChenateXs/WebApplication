package it.engineering.web.WebApp.service;

import java.util.List;

public interface IcrudService <T,ID> {
	void create(T entity) throws Exception;
	T read(ID id) throws Exception;
	void update(ID id, T entity) throws Exception;
	void delete(ID id) throws Exception;
	
	List<T> getAll();
}