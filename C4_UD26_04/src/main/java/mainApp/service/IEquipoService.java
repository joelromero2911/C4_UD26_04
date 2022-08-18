package mainApp.service;

import java.util.List;

import mainApp.dto.Equipo;

public interface IEquipoService {

	//Metodos del CRUD
	public List<Equipo> listarEquipos(); // Listar All 
	
	public Equipo guardarEquipo(Equipo equipo);	// CREATE
	
	public Equipo equipoXID(String num_serie); // READ
	
	public Equipo actualizarEquipos(Equipo equipo); // UPDATE
	
	public void eliminarEquipos(String num_serie); // DELETE
}
