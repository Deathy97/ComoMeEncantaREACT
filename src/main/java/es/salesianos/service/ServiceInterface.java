package es.salesianos.service;

import java.util.List;


public interface ServiceInterface<T> {

	List<T> listAllUser();
	void insert(T t);
}
