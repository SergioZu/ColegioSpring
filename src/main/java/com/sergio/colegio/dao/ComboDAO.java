package com.sergio.colegio.dao;


import java.util.List;

import com.sergio.colegio.dto.ComboDTO;

public interface ComboDAO {
	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
	

}
