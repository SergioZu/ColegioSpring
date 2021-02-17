package com.sergio.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.sergio.colegio.dao.NotasDAO;
import com.sergio.colegio.dto.NotaDTO;
import com.sergio.colegio.entities.AlumnoEntity;
import com.sergio.colegio.entities.AsignaturaEntity;
import com.sergio.colegio.entities.NotaEntity;
import com.sergio.colegio.repositorios.AlumnoRepository;
import com.sergio.colegio.repositorios.AsignaturaRepository;
import com.sergio.colegio.repositorios.NotaRepository;

@Service
public class NotasDAOImplement  implements NotasDAO{

	@Autowired
	private NotaRepository notaRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public List<NotaDTO> buscaNotaporIdNombresNotaFecha(Integer idAlumno, String nombreAlumno, Integer idAsignatura,
			String nombreAsignatura, Double nota, String fecha) {
		return notaRepository.buscaNotaporIdNombresNotaFecha(idAlumno, nombreAlumno, idAsignatura, nombreAsignatura, nota, fecha);
	}
	
	@Override
	public Integer insertarNota(Integer alumno, Integer asignatura, Double nota, String fecha) {
		AlumnoEntity alumnos = alumnoRepository.findById(alumno).get();
		AsignaturaEntity asignaturas = asignaturaRepository.findById(asignatura).get();
		
		NotaEntity notas = new NotaEntity( alumnos, asignaturas, nota, fecha);

		notaRepository.save(notas);
		return 1;
		
		
	}
	
	
	@Override
	public Integer actualizarNota(Integer id, Integer alumno, Integer asignatura, Double nota, String fecha,
			ModelMap model) {

		AlumnoEntity alumnos = alumnoRepository.findById(alumno).get();
		AsignaturaEntity asignaturas = asignaturaRepository.findById(asignatura).get();
		
		NotaEntity notas = new NotaEntity( id, alumnos, asignaturas, nota, fecha);

		notaRepository.save(notas);
		
		
		return 1;
	}
	
	
	
	@Override
	public Integer eliminarnotas(Integer id) {
		
		notaRepository.deleteById(id);
		return 1;
	}




	



}
