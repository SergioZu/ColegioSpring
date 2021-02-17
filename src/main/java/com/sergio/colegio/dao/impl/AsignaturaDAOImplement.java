package com.sergio.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.AsignaturaDAO;
import com.sergio.colegio.dto.AsignaturaDTO;
import com.sergio.colegio.entities.AsignaturaEntity;
import com.sergio.colegio.repositorios.AsignaturaRepository;

@Service
public class AsignaturaDAOImplement implements AsignaturaDAO{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	
	
	@Override
	public List<AsignaturaDTO> buscaAsignaturaporIdNombreCursoTasa(Integer id, String nombre, Integer curso,
			Double tasa) {
		return asignaturaRepository.buscaAsignaturaporIdNombreCursoTasa(id, nombre, curso, tasa);
	}
	
	
	
	@Override
	public List<AsignaturaDTO> obtenerAsignaturaporIdyNombre(Integer id, String nombre) {
		
		return asignaturaRepository.buscaAsignaturaporIDyNombre(id, nombre);
	}
	
	

	
	@Override
	public Integer insertarasignatura(Integer id, String nombre, Integer curso, Double tasa) {
		
		AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa);
		
		asignaturaRepository.save(asignatura);		
		
		return 1;
	}
	
	
	

	
	@Override
	public Integer actualizarasignatura(Integer id, String nombre, Integer curso, Double tasa) {
		
		AsignaturaEntity asignatura = new AsignaturaEntity(id, nombre, curso, tasa);
		
		asignaturaRepository.save(asignatura);
		
		
		return 1;
	}
	
	
	
	
	
	@Override
	public Integer eliminarasignatura(Integer id) {
		
		asignaturaRepository.deleteById(id);
		return 1;
	}




	
	
	
	
	
	
	
	
	
}
