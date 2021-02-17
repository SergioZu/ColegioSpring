package com.sergio.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.NotasDAO;
import com.sergio.colegio.dto.NotaDTO;
import com.sergio.colegio.repositorios.NotaRepository;

@Service
public class NotasDAOImplement  implements NotasDAO{

	@Autowired
	private NotaRepository notaRepository;
	
	@Override
	public List<NotaDTO> buscaNotaporIdNombresNotaFecha(Integer idAlumno, String nombreAlumno, Integer idAsignatura,
			String nombreAsignatura, Double nota, String fecha) {
		return notaRepository.buscaNotaporIdNombresNotaFecha(idAlumno, nombreAlumno, idAsignatura, nombreAsignatura, nota, fecha);
	}

}
