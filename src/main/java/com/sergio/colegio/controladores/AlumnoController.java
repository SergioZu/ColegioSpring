package com.sergio.colegio.controladores;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.entities.AlumnoEntity;
import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dto.AlumnoDTO;
import com.sergio.colegio.repositorios.AlumnoRepository;

@Controller
public class AlumnoController {
	@Autowired
	private ComboDAO comboDAO;
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(AlumnoController.class);
	
	
	@GetMapping(value="listadoalumnos")
	public String formularioListarAlumnos(ModelMap model) {
		return "vistas/alumnos/listadoAlumnos";
	}
	
	@PostMapping(value = "listadoalumnos")
	public String  ListarAlumnos(@RequestParam(value = "id",required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		List<AlumnoDTO> listaAlumnos= alumnoRepository.buscaAlumnoporIdyNombre(id, nombre);
		model.addAttribute("lista",listaAlumnos);
		return "vistas/alumnos/listadoAlumnos";
	}
	
	
	@GetMapping(value="insertaralumno")
	public String formularioInsertarAlumnos(ModelMap model) {
		model.addAttribute("comboMunicipios",comboDAO.comboMunicipios());
		return "vistas/alumnos/insertarAlumnos";
	}
	
	
	@PostMapping(value="insertaralumno")
	public String  InsertarAlumno(@RequestParam(value = "id",required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value="municipios") Integer idMunicipio,
			@RequestParam(value="familiaNumerosa",required = false) Integer familiaNumerosa, ModelMap model) {
		
		familiaNumerosa=(familiaNumerosa==null)?0:1;
		
		AlumnoEntity alumnoEntity=new AlumnoEntity(id, nombre, idMunicipio, familiaNumerosa);
		
		alumnoRepository.save(alumnoEntity);
		model.addAttribute("comboMunicipios",comboDAO.comboMunicipios());
		return "vistas/alumnos/insertarAlumnos";
		
	}
	
	@GetMapping(value="formularioborraralumnos")
	public String formularioBorrarAlumnos(ModelMap model) {
		return "vistas/alumnos/borrarAlumnos";
	}
	
	@PostMapping(value = "formularioborraralumnos")
	public String  ListarAlumnosBorrar(@RequestParam(value = "id",required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		List<AlumnoDTO> listaAlumnos= alumnoRepository.buscaAlumnoporIdyNombre(id, nombre);
		model.addAttribute("lista",listaAlumnos);
		return "vistas/alumnos/borrarAlumnos";
	}
	
	@PostMapping(value = "borraralumno")
	public String borraralumno(@RequestParam(value = "id",required = true) Integer id, ModelMap model)  {
		alumnoRepository.deleteById(id);
		return "vistas/alumnos/borrarAlumnos";
	}
	
	
	@GetMapping(value="formularioactualizaralumnos")
	public String formularioActualizarAlumnos(ModelMap model) {
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	@PostMapping(value = "formularioactualizaralumnos")
	public String  ListarAlumnosActualizar(@RequestParam(value = "id",required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		List<AlumnoDTO> listaAlumnos= alumnoRepository.buscaAlumnoporIdyNombre(id, nombre);
		model.addAttribute("lista",listaAlumnos);
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	@PostMapping(value="actualizaralumno")
	public String  ActualizarAlumno(@RequestParam(value = "id",required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam(value="municipios") Integer idMunicipio,
			@RequestParam(value="familiaNumerosa",required = false) Integer familiaNumerosa, ModelMap model) {
		
		familiaNumerosa=(familiaNumerosa==null)?0:1;
		
		AlumnoEntity alumnoEntity=new AlumnoEntity(id, nombre, idMunicipio, familiaNumerosa);
		
		alumnoRepository.save(alumnoEntity);
		return "vistas/alumnos/actualizarAlumnos";
		
	}
	
	
	
	
}
