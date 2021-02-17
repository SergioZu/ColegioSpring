package com.sergio.colegio.dao;
import java.util.List;
import com.sergio.colegio.dto.AsignaturaDTO;



public interface AsignaturaDAO {
		List<AsignaturaDTO> obtenerAsignaturaporIdyNombre(Integer id, String nombre);
		Integer insertarasignatura(Integer id, String nombre, Integer curso, Double tasa);
		Integer actualizarasignatura(Integer id, String nombre, Integer curso, Double tasa);
		Integer eliminarasignatura(Integer id);
	

}
