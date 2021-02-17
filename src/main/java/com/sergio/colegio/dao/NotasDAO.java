package com.sergio.colegio.dao;

import java.util.List;



import com.sergio.colegio.dto.NotaDTO;

public interface NotasDAO {
	List<NotaDTO>buscaNotaporIdNombresNotaFecha(Integer idAlumno, String nombreAlumno,
			Integer idAsignatura,String nombreAsignatura,  Double nota,String fecha);
}
