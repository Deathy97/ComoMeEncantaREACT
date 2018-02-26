package es.salesianos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

@Service
public class ActorService implements ServiceInterface<Actor> {

	@Autowired
	private ActorRepository repository;

	@Override
	public List<Actor> listAllUser() {
		return repository.listAllUsers();
	}

	@Override
	public void insert(Actor t) {
		repository.insert(t);
	}

	public void update(String dni) {
		repository.update(dni);
	}

	public void delete(String tablename, String id) {
		repository.delete(tablename, id);
	}

}
