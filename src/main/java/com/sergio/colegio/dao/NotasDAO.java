package com.sergio.colegio.dao;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.sergio.colegio.dto.NotaDTO;

public interface NotasDAO {
	List<NotaDTO>buscaNotaporIdNombresNotaFecha(Integer idAlumno, String nombreAlumno,Integer idAsignatura,String nombreAsignatura,  Double nota,String fecha);
	Integer insertarNota(Integer alumno,Integer asignatura,Double nota,String fecha);
	Integer eliminarnotas(Integer id);
	Integer actualizarNota(Integer id, Integer alumno, Integer asignatura, Double nota, String fecha, ModelMap model);
}
