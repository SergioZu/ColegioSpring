package com.sergio.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.colegio.dto.AlumnoDTO;
import com.sergio.colegio.entities.AlumnoEntity;
import com.sergio.colegio.repositorios.AlumnoRepository;


@RestController
@RequestMapping("/v1")
public class AlumnoRestController {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
	
	@PostMapping("/alumnos")
	public ResponseEntity<String>insertarAlumno(@RequestBody AlumnoEntity alumno){
		alumnoRepository.save(alumno);
		return new ResponseEntity<>("Inserción correcta!",HttpStatus.OK);
	}
	
	@GetMapping(value = "/alumnos")
	public Iterable<AlumnoEntity> listarTodosAlumnos(){
		return alumnoRepository.findAll();
	}
	
	@GetMapping(value = "/alumnos/{id}")
	public Optional<AlumnoEntity> buscarAlumnoPorID(@PathVariable("id")Integer id){
		return alumnoRepository.findById(id);
	}
	
	@GetMapping(value = "/alumnos",params  ={"id","nombre"})
	public List<AlumnoDTO> listarAlumnosPorIdNombre(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre){
		
		return alumnoRepository.buscaAlumnoporIdyNombre(id, nombre);
	}
	
	@PutMapping(value="/alumnos")
	public ResponseEntity<String> actualizarAlumno(@RequestBody AlumnoEntity alumno){
		alumnoRepository.save(alumno);
		return new ResponseEntity<>("actualizacion correcta!",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/alumnos/{id}")
	public ResponseEntity<String>MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
		alumnoRepository.deleteById(id);
		return new ResponseEntity<>("Borrado correcto!",HttpStatus.OK);
	}
}
