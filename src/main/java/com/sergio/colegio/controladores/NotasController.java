package com.sergio.colegio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dto.NotaDTO;
import com.sergio.colegio.entities.AlumnoEntity;
import com.sergio.colegio.entities.AsignaturaEntity;
import com.sergio.colegio.entities.NotaEntity;
import com.sergio.colegio.repositorios.AlumnoRepository;
import com.sergio.colegio.repositorios.AsignaturaRepository;
import com.sergio.colegio.repositorios.NotaRepository;

@Controller
public class NotasController {
	

	@Autowired
	private ComboDAO comboDao;
	
	@Autowired
	private NotaRepository notasDAO;
	
	@Autowired
	private AlumnoRepository alumnoDAO;
	
	@Autowired
	private AsignaturaRepository asignaturaDAO;
	
	
	
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
	
	
	@GetMapping(value = "insertarnota")
	public String ListarInsertarnotas(ModelMap model) {
		model.addAttribute("listaAlumnos",comboDao.comboAlumnos());
		model.addAttribute("listaAsignaturas",comboDao.comboAsignaturas());
		return "vistas/notas/insertarNotas";
	}

	@PostMapping(value = "insertarnota")
	public String Insertarnota(
			@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		AlumnoEntity alumnoEntity = alumnoDAO.findById(alumno).get();
		AsignaturaEntity asignaturasEntity = asignaturaDAO.findById(asignatura).get();
		
		NotaEntity notas = new NotaEntity( alumnoEntity, asignaturasEntity, nota, fecha);

		notasDAO.save(notas);

		return "vistas/notas/insertarNotas";
	}

	
	
	
	
	
	@GetMapping(value = "formularioborrarnotas")
	public String borrarnota(ModelMap model) {
		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "formularioborrarnotas")
	public String ListadoBorrarnotas(@RequestParam(value = "nombre", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		List<NotaDTO> listaNotas = notasDAO.buscaNotaporIdNombresNotaFecha(null, alumno, null, asignatura, null, fecha);
				model.addAttribute("listaAlumnos",comboDao.comboAlumnos());
				model.addAttribute("listaAsignaturas",comboDao.comboAsignaturas());


		model.addAttribute("lista", listaNotas);

		return "vistas/notas/borrarNotas";
	}
	
	@PostMapping(value = "borrarnota")
	public String borrarnota(@RequestParam(value = "idNota", required = false) Integer id) {

		notasDAO.deleteById(id);

		return "vistas/notas/borrarNotas";
	}
	
	
	
	
	
	@GetMapping(value="formularioactualizarnota")
	public String formularioActualizarNotas(ModelMap model) {
		return "vistas/notas/actualizarNotas";
	}
	
	
	@PostMapping(value = "formularioactualizarnota")
	public String ListadoModificarnotas(@RequestParam(value = "nombre", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {

		List<NotaDTO> listaNotas = notasDAO.buscaNotaporIdNombresNotaFecha(null, alumno, null, asignatura, null, fecha);
				model.addAttribute("listaAlumnos",comboDao.comboAlumnos());
				model.addAttribute("listaAsignaturas",comboDao.comboAsignaturas());


		model.addAttribute("lista", listaNotas);

		return "vistas/notas/actualizarNotas";
	}

	@PostMapping(value = "actualizarnota")
	public String actualizarnota(@RequestParam(value = "idNota", required = false) Integer id,
			@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model) {
		
		AlumnoEntity alumnoEntity = alumnoDAO.findById(alumno).get();
		AsignaturaEntity asignaturasEntity = asignaturaDAO.findById(asignatura).get();
		
		NotaEntity notas = new NotaEntity( id, alumnoEntity, asignaturasEntity, nota, fecha);

		notasDAO.save(notas);

		return "vistas/notas/actualizarNotas";
	}
	
	
}
