package es.salesianos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.salesianos.model.Pelicula;
import es.salesianos.service.PeliculaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/pelicula")
public class PeliculaController {

	@Autowired
	private PeliculaService service;

	@RequestMapping(value = "/delete/{tablename}/", method = RequestMethod.GET)
	public ResponseEntity delete(@PathVariable String tablename, @RequestParam(required = false) Integer id) {
		service.delete(tablename, id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Pelicula> create(@RequestBody Pelicula pelicula) {
		service.insert(pelicula);
		return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Pelicula>> ListAll() {
		return new ResponseEntity<>(service.listAllUser(), HttpStatus.CREATED);
	}

}
