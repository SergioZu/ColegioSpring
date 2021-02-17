package com.sergio.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.sergio.colegio.dao.NotasDAO;
@Controller
public class NotasController {
	

	@Autowired
	private NotasDAO notasDAO;
	
	
	
	@GetMapping (value = "listadonotas")
	private String Hola (ModelMap model) {
		
		return "vistas/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotas")
	public String controlador(@RequestParam(value = "id", required = false) Integer idAlumno, @RequestParam("nombre") String nombreAlumno,
			@RequestParam(value = "idA", required = false) Integer idAsignatura, @RequestParam("asignatura") String nombreAsignatura,
			 @RequestParam(value ="nota",required = false) Double nota,  @RequestParam(value ="fecha",required = false) String fecha,
			 ModelMap model) {
		
		model.addAttribute("lista", notasDAO.buscaNotaporIdNombresNotaFecha(idAlumno, nombreAlumno, idAsignatura, nombreAsignatura, nota, fecha));
		return "vistas/notas/listadoNotas";
	}
	
}
