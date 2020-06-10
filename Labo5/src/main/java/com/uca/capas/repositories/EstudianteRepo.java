package com.uca.capas.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {

	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.estudiante")
	public List<Estudiante> mostrarTodo() throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.estudiante WHERE nombre = ?1")
	public List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException;

	@Transactional
	@Modifying
	@Query("UPDATE Estudiante e SET e.nombre = ?1, e.apellido = ?2, e.edad = ?3, e.estado =?4 WHERE id_estudiante = ?5")
	public void ActualizarEst(String nombre, String apellido, Integer edad, Boolean estado, Integer codigo) throws DataAccessException;
}
