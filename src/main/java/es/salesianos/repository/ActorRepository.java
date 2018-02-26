package es.salesianos.repository;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Actor;

@Repository
public class ActorRepository {

	private static Logger log = LogManager.getLogger(ActorRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void insert(Actor actor) {
		String sql = "INSERT INTO Actor (dni,nombre,fechaNacimiento)" + "VALUES ( :dni, :nombre, :fechaNacimiento)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("dni", actor.getDni());
		params.addValue("nombre", actor.getNombre());
		params.addValue("fechaNacimiento", actor.getFechaNacimiento());
		namedJdbcTemplate.update(sql, params);
	}

	public void update(String dni) { 
		String sql = "UPDATE Actor SET nombre = 'Paco' WHERE dni = ?";
		jdbcTemplate.update(sql, dni);
	}

	public List<Actor> listAllUsers() {
		String sql = "SELECT * FROM Actor";
		List<Actor> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Actor.class));
		return users;
	}

	public void delete(String tablename, String id) {//cambiar todos id como dice el maestro miguel ole ole paella 
		// log.debug("id: " + id.toString());
		log.debug("tablename: " + tablename);
		String sql = "DELETE FROM " + tablename + " WHERE dni = ?";
		log.debug(sql);
		jdbcTemplate.update(sql, id.toString());
	}

}
