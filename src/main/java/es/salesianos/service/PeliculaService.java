package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Pelicula;
import es.salesianos.repository.PeliculaRepository;

@Service
public class PeliculaService implements ServiceInterface<Pelicula> {

	@Autowired
	private PeliculaRepository repository;

	@Override
	public List<Pelicula> listAllUser() {
		return repository.listAllPelicula();

	}

	@Override
	public void insert(Pelicula t) {
		repository.insert(t);
	}

	public void delete(String tablename, int id) {
		repository.delete(tablename, id);
	}

	public void update(Pelicula t) {
		repository.update(t);
	}

}
