package mainApp.service;

import java.util.List;

import mainApp.dto.Reserva;

public interface IReservaService {

	//Metodos del CRUD
	public List<Reserva> listarReservas(); // Listar All 
	
	public Reserva guardarReserva(Reserva reserva);	// CREATE
	
	public Reserva reservaXID(int id); // READ
	
	public Reserva actualizarReservas(Reserva reserva); // UPDATE
	
	public void eliminarReservas(int id); // DELETE
}
