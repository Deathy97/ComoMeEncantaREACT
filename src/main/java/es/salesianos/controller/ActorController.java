package es.salesianos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/actor")
public class ActorController {

	@Autowired
	private ActorService service;
	
	private static Logger log = LogManager.getLogger(ActorService.class);
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ResponseEntity cambiar(@RequestParam(required = false) String dni) {
		service.update(dni);
		return new ResponseEntity(HttpStatus.OK);
}

	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Actor> create(@RequestBody Actor actor) {
		service.insert(actor);
		return new ResponseEntity<>(actor, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Actor>> ListAll() {
		return new ResponseEntity<>(service.listAllUser(), HttpStatus.CREATED);
	}

}
