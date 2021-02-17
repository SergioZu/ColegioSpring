package com.sergio.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.sergio.colegio.dto.NotaDTO;
import com.sergio.colegio.entities.NotaEntity;



public interface NotaRepository extends CrudRepository<NotaEntity, Integer> {
	
	@Query(value = "select new com.sergio.colegio.dto.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.sergio.colegio.entities.NotaEntity n "
			+ "INNER JOIN com.sergio.colegio.entities.AlumnoEntity as a on n.alumnos.id = a.id "
			+ "INNER JOIN com.sergio.colegio.entities.AsignaturaEntity as asig on n.asignaturas.id = asig.id "
			+ "WHERE (a.id LIKE CONCAT('%',:id_alumnos,'%') or :id_alumnos is null) "
			+ "AND a.nombre LIKE CONCAT('%',:nombreAlumno, '%') "
			+ "AND (asig.id LIKE CONCAT('%',:idAsignatura,'%') or :idAsignatura is null) "
			+ "AND asig.nombre LIKE CONCAT('%',:nombreAsignatura, '%') "
			+ "AND (n.nota LIKE CONCAT('%',:nota, '%') or :nota is null) "
			+ "AND n.fecha LIKE CONCAT('%',:fecha, '%')")
	
			List<NotaDTO>buscaNotaporIdNombresNotaFecha(@Param("id_alumnos") Integer idAlumno, @Param("nombreAlumno") String nombreAlumno,
					@Param("idAsignatura") Integer idAsignatura, @Param("nombreAsignatura") String nombreAsignatura, 
					@Param("nota") Double nota, @Param("fecha") String fecha);
	

	
	
}
