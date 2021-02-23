package com.sergio.colegio.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dto.ComboDTO;

@RestController
@RequestMapping("/v1")
public class ComboRestController {

	@Autowired
	ComboDAO combo;
	
	@GetMapping(value = "combos/municipios")     
	public List<ComboDTO> comboMunicipios(){        
		List<ComboDTO> listaMunicipios = combo.comboMunicipios();         
		return listaMunicipios;     
	}          
	
	@GetMapping(value = "combos/alumnos")     
	public List<ComboDTO> comboAlumnos(){         
		List<ComboDTO> listaAlulmnos = combo.comboAlumnos();         
		return listaAlulmnos;     
	}          
	
	@GetMapping(value = "combos/asignaturas")     
	public List<ComboDTO> comboAsignaturas(){         
		List<ComboDTO> listaAsignaturas = combo.comboAsignaturas();         
		return listaAsignaturas;     
		}
}
