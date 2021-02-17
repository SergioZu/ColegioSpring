package com.sergio.colegio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dto.ComboDTO;
import com.sergio.colegio.entities.AlumnoEntity;
import com.sergio.colegio.entities.AsignaturaEntity;
import com.sergio.colegio.entities.MunicipioEntity;
import com.sergio.colegio.repositorios.AlumnoRepository;
import com.sergio.colegio.repositorios.AsignaturaRepository;
import com.sergio.colegio.repositorios.MunicipioRepository;
@Service
public class ComboDAOImplement implements ComboDAO{
	@Autowired
	private MunicipioRepository municipioEntity;
	
	@Autowired
	private AlumnoRepository alumnoEntity;
	
	@Autowired
	private AsignaturaRepository asignaturaEntity;
	
	@Override
	public List<ComboDTO> comboMunicipios() {

		Iterable<MunicipioEntity> listaEntidadesMunicipios=municipioEntity.findAll();
		List<ComboDTO> listaMunicipios=mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {

		Iterable<AlumnoEntity> listaEntidadesAlumno=alumnoEntity.findAll();
		List<ComboDTO> listaAlumnos=mapeoEntidadAlumnoComboDTO(listaEntidadesAlumno);
		return listaAlumnos;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {

		Iterable<AsignaturaEntity> listaEntidadesAsignatura=asignaturaEntity.findAll();
		List<ComboDTO> listaAsignatura=mapeoEntidadAsignaturaComboDTO(listaEntidadesAsignatura);
		return listaAsignatura;
	}

	private List<ComboDTO> mapeoEntidadMunicipioComboDTO(Iterable<MunicipioEntity> listaEntidadesMunicipio){
		List<ComboDTO> listaMunicipios=new ArrayList<>();
		
		for(MunicipioEntity m: listaEntidadesMunicipio) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		
		return listaMunicipios;
	}
	
	private List<ComboDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> listaEntidadesMunicipio){
		List<ComboDTO> listaMunicipios=new ArrayList<>();
		
		for(AlumnoEntity m: listaEntidadesMunicipio) {
			listaMunicipios.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		
		return listaMunicipios;
	}
	
	private List<ComboDTO> mapeoEntidadAsignaturaComboDTO(Iterable<AsignaturaEntity> listaEntidadesMunicipio){
		List<ComboDTO> listaMunicipios=new ArrayList<>();
		
		for(AsignaturaEntity m: listaEntidadesMunicipio) {
			listaMunicipios.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		
		return listaMunicipios;
	}

}
