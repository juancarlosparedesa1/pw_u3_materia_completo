package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

//	@Override
//	public void ingresar(Estudiante estudiante) {
//		// TODO Auto-generated method stub
//		this.estudianteRepository.insertar();
//	}
	// conexion backend
	@Override
	public void ingresar(EstudianteTO estudianteTo) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(convertirAEntidad(estudianteTo));
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

//	@Override
//	public void actualizar(Estudiante estudiante) {
//		// TODO Auto-generated method stub
//		this.estudianteRepository.actualizar(estudiante);
//	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}

	// HATEOAS CONVERTIR DE TO A ENTIDAD

	public Estudiante convertirAEntidad(EstudianteTO estudianteTo) {
		Estudiante estudiante = new Estudiante();
//		estudiante.setId(estudianteTo.getId());
		estudiante.setCedula(estudianteTo.getCedula());// conexion frontend
		estudiante.setNombre(estudianteTo.getNombre());
		estudiante.setApellido(estudianteTo.getApellido());
		estudiante.setCarrera(estudianteTo.getCarrera());
		estudiante.setGenero(estudianteTo.getGenero());
		return estudiante;
	}

	// hateoas metodos CONVERTIR DE ENTIDAD A TO
	public EstudianteTO convertirTo(Estudiante estudiante) {
		EstudianteTO estudianteTO = new EstudianteTO();
//		estudianteTO.setId(estudiante.getId());
		estudianteTO.setCedula(estudiante.getCedula());
		estudianteTO.setNombre(estudiante.getNombre());
		estudianteTO.setApellido(estudiante.getApellido());
		// estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		estudianteTO.setCarrera(estudiante.getCarrera());
		estudianteTO.setGenero(estudiante.getGenero());
		return estudianteTO;
	}

	public EstudianteTO buscarPorId(Integer id) {
		Estudiante estudiante = this.estudianteRepository.seleccionar(id);

		// APORTE A MANERA DE PRUEBA SE UTILIZA EN TRY Y CATCH
		/*
		 * try { return this.convertirTo(estudiante) ;//me retorna un estudianteTO
		 * 
		 * } catch (Exception e) { System.out.println("Estudiante no encontrado");
		 * return null;// TODO: handle exception }
		 */
		return this.convertirTo(estudiante);// me retorna un estudianteTO
	}

	@Override
	public List<EstudianteTO> buscarTodosHateoas() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> listaFinal = new ArrayList();
		for (Estudiante estudiante : lista) {
			listaFinal.add(this.convertirTo(estudiante));
		}
		return listaFinal;
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);
		return this.convertirTo(estudiante);
	}

//	@Override
//	public void actualizarPorCedula(EstudianteTO estudianteTO) {
//		// TODO Auto-generated method stub
//		Estudiante estudiante = this.convertirAEntidad(estudianteTO);
//		this.estudianteRepository.actualizar(estudiante);
//
//	}

	public void actualizarPorCedula(EstudianteTO estudianteTo, String cedula) {

		// Obtiene un objeto Estudiante existente usando la cédula proporcionada.
		Estudiante estuExistente = this.estudianteRepository.seleccionarPorCedula(cedula);

		// Actualiza los campos del objeto Estudiante existente con los valores del
		// objeto EstudianteTO.
		estuExistente.setNombre(estudianteTo.getNombre());
		estuExistente.setApellido(estudianteTo.getApellido());
		estuExistente.setCarrera(estudianteTo.getCarrera());
		estuExistente.setGenero(estudianteTo.getGenero());

		// Guarda el objeto Estudiante actualizado en el repositorio.
		this.estudianteRepository.actualizar(estuExistente);
	}

	@Override
	public void borrarPorCedula(String Cedula) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminarPorCedula(Cedula);
	}

}
