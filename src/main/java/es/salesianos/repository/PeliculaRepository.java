package es.salesianos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import es.salesianos.model.Pelicula;

@Repository
public class PeliculaRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Pelicula pelicula) {
		String sql = "INSERT INTO pelicula (id,nombre,fechaEstreno)" + "VALUES ( :id, :nombre, :fechaEstreno)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", pelicula.getId());
		params.addValue("nombre", pelicula.getNombre());
		params.addValue("fechaEstreno", pelicula.getFechaEstreno());
		namedJdbcTemplate.update(sql, params);
	}

	public void update(Pelicula pelicula) { 
		String sql = "UPDATE pelicula SET " + "nombre = ?, fechaEstreno = ? WHERE id = ?";
		jdbcTemplate.update(sql, pelicula.getNombre(), pelicula.getFechaEstreno(), pelicula.getId());
	}

	public List<Pelicula> listAllPelicula() {
		String sql = "SELECT * FROM Pelicula";
		List<Pelicula> listPelicula = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Pelicula.class));
		return listPelicula;
	}

	public void delete(String tablename, int id) {//cambiar todos id como dice el maestro miguel ole ole paella 
		// log.debug("id: " + id.toString())
		String sql = "DELETE FROM " + tablename + " WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
