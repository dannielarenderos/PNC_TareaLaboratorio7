package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante{
	
	@Id
	@Column(name="id_estudiante")
	@GeneratedValue(generator= "estudiante_id_estudiante_seq", strategy= GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Size(message="El nombre no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="nombre")
	private String nombre;
	
	@Size(message="El apellido no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="apellido")
	private String apellido;
	
	@Min(value = 18,message="La edad no debe ser menor de 18 ")
	@NotNull(message="No puede estar vacio")
	@Column(name="edad")
	private Integer edad;
	
	
	@Column(name="estado")
	private Boolean estado;
	
	
	public Estudiante() {

	}


	public Estudiante(Integer codigoEstudiante,
			@Size(message = "El nombre no debe tener mas de 50 caracteres", max = 30) @NotEmpty(message = "No puede estar vacio") String nombre,
			@Size(message = "El nombre no debe tener mas de 50 caracteres", max = 30) @NotEmpty(message = "No puede estar vacio") String apellido,
			@Size(message = "El carne no debe tener mas de 10 caracteres", max = 10) @NotEmpty(message = "No puede estar vacio") Integer edad,
			@Size(message = "El carrera no debe tener mas de 100 caracteres", max = 100) @NotEmpty(message = "No puede estar vacio") Boolean estado) {
		super();
		this.codigoEstudiante = codigoEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estado = estado;
	}


	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}


	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getEstadoDelegate() {
		if(this.estado == null ) return "";
		else {
			return estado == true?"Activo":"Inactivo";
		}
	}
	
	
	
	
}
	