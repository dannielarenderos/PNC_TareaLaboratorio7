package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteRepo estudianteRepo;
	// private EstudianteDAO estudianteDAO;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.mostrarTodo();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteRepo.getOne(code);
	}

	@Transactional
	@Override
	public void save(Estudiante estudiante) throws DataAccessException {
		
		estudianteRepo.save(estudiante);
	}

	@Override
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteRepo.deleteById(codigoEstudiante);
	}

	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		return estudianteRepo.mostrarPorNombre(cadena);
	}

	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException {
		return estudianteRepo.findByApellidoStartingWith(cadena);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) throws DataAccessException {
	
		estudianteRepo.ActualizarEst(estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad(), estudiante.getEstado(), estudiante.getCodigoEstudiante());
	}
	
	
}