package mainApp.service;

import java.util.List;

import mainApp.dto.Facultad;

public interface IFacultadService {

	//Metodos del CRUD
	public List<Facultad> listarFacultades(); // Listar All 
	
	public Facultad guardarFacultad(Facultad facultad);	// CREATE
	
	public Facultad facultadXID(int codigo); // READ
	
	public Facultad actualizarFacultades(Facultad facultad); // UPDATE
	
	public void eliminarFacultades(int codigo); // DELETE
}
