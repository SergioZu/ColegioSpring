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

import com.sergio.colegio.entities.MatriculacionEntity;
import com.sergio.colegio.repositorios.CajaRepository;
import com.sergio.colegio.repositorios.MatriculaRepository;


@RestController
@RequestMapping("/v1")
public class MatriculacionRestController {

	@Autowired
	private MatriculaRepository matricula;
	
	@Autowired
	private CajaRepository caja;
	
	@PostMapping("/matriculacion")
	public ResponseEntity<String>insertarAlumno(@RequestBody MatriculacionEntity matriculacionEntity){
		matricula.save(matriculacionEntity);
		return new ResponseEntity<>("Inserción correcta!",HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/matriculacion")
	public Iterable<MatriculacionEntity> listarTodosNotas(){
		return matricula.findAll();
	}
	
	@GetMapping(value = "/matriculacion/{id}")
	public Optional<MatriculacionEntity> buscarAlumnoPorID(@PathVariable("id")Integer id){
		return matricula.findById(id);
	}
	
	@PutMapping(value="/matriculacion")
	public ResponseEntity<String> actualizarNotas(@RequestBody MatriculacionEntity matriculacionEntity){
		matricula.save(matriculacionEntity);
		return new ResponseEntity<>("actualizacion correcta!",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/matriculacion/{id}")
	public ResponseEntity<String>MostrarFormularioBorrarNotas(@PathVariable("id") Integer id){
		
		matricula.deleteById(id);
		return new ResponseEntity<>("Borrado correcto!",HttpStatus.OK);
	}
}
