package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	// public void ingresar(Estudiante estudiante);
	public void ingresar(EstudianteTO estudianteTo);// conexion con frontend

	public Estudiante buscar(Integer id);

//	public void actualizar(Estudiante estudiante);
	// actualizar
	public void actualizarPorCedula(EstudianteTO estudianteTO, String cedula);

	public void borrar(Integer id);

	public List<Estudiante> buscarPorGenero(String genero);

	// hateoas para usar el convertir
	public EstudianteTO buscarPorId(Integer id);

	// buscarTodoshateoas
	public List<EstudianteTO> buscarTodosHateoas();

	// metodo conexion con el frontend
	// buscarPorCedula
	public EstudianteTO buscarPorCedula(String cedula);

	public void borrarPorCedula(String Cedula);
}
