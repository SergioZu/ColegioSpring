package com.sergio.colegio.controladores;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sergio.colegio.dao.AsignaturaDAO;
import com.sergio.colegio.dao.ComboDAO;

@Controller
public class AsignaturaController {
	
	@Autowired
	private ComboDAO combo;

	@Autowired
	private AsignaturaDAO asignaturaIml;
	
	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);
	
	
	
	@GetMapping (value = "listadoasignaturas")
	private String Hola (ModelMap model) {
		
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturas")
	public String controlador(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre,
			 @RequestParam(value ="curso",required = false) Integer curso,  @RequestParam(value ="tasa",required = false) Double tasa,
			 ModelMap model) {
		
		model.addAttribute("lista", asignaturaIml.buscaAsignaturaporIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	
	
	@GetMapping (value = "insertarasignaturas")
	public String formularioInsertarAsignaturas(ModelMap model) {
		
		return "vistas/asignaturas/insertarAsignaturas";		
	}
	
	
	
	@PostMapping(value = "insertarasignaturas")
	public String InsertarAsignatura(@RequestParam(value = "id", required = true) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam("curso") Integer curso, 
			@RequestParam("tasa") Double tasa, ModelMap model) {
		
		model.addAttribute("resultado", asignaturaIml.insertarasignatura(id, nombre, curso, tasa));
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	@GetMapping(value = "formularioborrarasignatura")
	public String formularioborrarasignaturas(ModelMap model) {
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	@PostMapping(value = "formularioborrarasignatura")
	public String listadoasignaturaborrar(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		
		model.addAttribute("lista", asignaturaIml.obtenerAsignaturaporIdyNombre(id, nombre));
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	
	@PostMapping(value = "borrarasignatura")
	public String borraralumno(@RequestParam(value = "id",required = true) Integer id, ModelMap model) {
		
		model.addAttribute("resultado", asignaturaIml.eliminarasignatura(id));
		
		return "vistas/asignaturas/borrarAsignaturas";
	}
	
	
	
	@GetMapping(value = "formularioactualizarasignatura")
	public String formularioactualizarasignaturas(ModelMap model) {
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "formularioactualizarasignatura")
	public String listadoasignaturasactualizar(@RequestParam(value = "id", required = false) Integer id, @RequestParam("nombre") String nombre, ModelMap model) {
		
		model.addAttribute("lista", asignaturaIml.obtenerAsignaturaporIdyNombre(id, nombre));
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "actualizarasignatura")
	public String actualizarAlumn(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, @RequestParam("curso") Integer curso, 
			@RequestParam("tasa") Double tasa, ModelMap model) {
		
		model.addAttribute("resultado", asignaturaIml.actualizarasignatura(id, nombre, curso, tasa));	
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	
	
	
	
}
