package com.sergio.colegio.controladores.rest;



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
import org.springframework.web.bind.annotation.RestController;

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
	
	
	@GetMapping(value = "/notas")
	public Iterable<NotaEntity> listarTodosNotas(){
		return notaRepository.findAll();
	}
	
	@GetMapping(value = "/notas/{id}")
	public Optional<NotaEntity> buscarAlumnoPorID(@PathVariable("id")Integer id){
		return notaRepository.findById(id);
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
