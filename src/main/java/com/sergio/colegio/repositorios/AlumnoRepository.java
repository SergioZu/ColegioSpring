package com.sergio.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sergio.colegio.dto.AlumnoDTO;
import com.sergio.colegio.entities.AlumnoEntity;

public interface AlumnoRepository  extends CrudRepository<AlumnoEntity, Integer>{
	
	@Query(value = "select new com.sergio.colegio.dto.AlumnoDTO (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.sergio.colegio.entities.AlumnoEntity a, com.sergio.colegio.entities.MunicipioEntity m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT('%',:nombre,'%')")
			List<AlumnoDTO>buscaAlumnoporIdyNombre(@Param("id") Integer id, @Param("nombre") String nombre);
}
