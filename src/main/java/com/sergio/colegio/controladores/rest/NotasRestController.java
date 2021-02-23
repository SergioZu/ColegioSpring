package com.sergio.colegio.controladores.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.repository.query.Param;
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

import com.sergio.colegio.dto.NotaDTO;
import com.sergio.colegio.entities.NotaEntity;
import com.sergio.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping("/v1")
public class NotasRestController {

	@Autowired
private NotaRepository notaRepository;
	
	
	
	@PostMapping("/notas")
	public ResponseEntity<String>insertarAlumno(@RequestBody NotaEntity notaEntity){
		notaRepository.save(notaEntity);
		return new ResponseEntity<>("Inserción correcta!",HttpStatus.OK);
	}
	
	
//	@GetMapping(value = "/notas")
//	public Iterable<NotaEntity> listarTodosNotas(){
//		return notaRepository.findAll();
//	}
//	
	@GetMapping(value = "/notas/{id}")
	public Optional<NotaEntity> buscarAlumnoPorID(@PathVariable("id")Integer id){
		return notaRepository.findById(id);
	}
	
	@GetMapping(value = "/notas")
	public List<NotaDTO> listarAlumnosPorTodo(
												@RequestParam(value= "id_alumnos", required=false) Integer idAlumno, 
												@RequestParam(value="nombreAlumno", required=false) String nombreAlumno,
												@RequestParam(value="idAsignatura", required=false) Integer idAsignatura, 
												@RequestParam(value="nombreAsignatura", required=false) String nombreAsignatura, 
												@RequestParam(value="nota", required=false) Double nota, 
												@RequestParam(value="fecha", required=false) String fecha){
		
		return notaRepository.buscaNotaporIdNombresNotaFecha(idAlumno, nombreAlumno, idAsignatura, nombreAsignatura, nota, fecha);
	}
	
	@PutMapping(value="/notas")
	public ResponseEntity<String> actualizarNotas(@RequestBody NotaEntity notaEntity){
		notaRepository.save(notaEntity);
		return new ResponseEntity<>("actualizacion correcta!",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/notas/{id}")
	public ResponseEntity<String>MostrarFormularioBorrarNotas(@PathVariable("id") Integer id){
		notaRepository.deleteById(id);
		return new ResponseEntity<>("Borrado correcto!",HttpStatus.OK);
	}
}
