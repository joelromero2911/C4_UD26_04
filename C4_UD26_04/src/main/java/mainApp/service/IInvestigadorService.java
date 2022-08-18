package mainApp.service;

import java.util.List;

import mainApp.dto.Investigador;

public interface IInvestigadorService {

	//Metodos del CRUD
	public List<Investigador> listarInvestigadores(); // Listar All 
	
	public Investigador guardarInvestigador(Investigador investigador);	// CREATE
	
	public Investigador investigadorXID(String dni); // READ
	
	public Investigador actualizarInvestigadores(Investigador investigador); // UPDATE
	
	public void eliminarInvestigadores(String dni); // DELETE
}
