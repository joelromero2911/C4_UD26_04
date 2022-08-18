package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IReservaDAO;
import mainApp.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDAO iReservaDAO;
	
	@Override
	public List<Reserva> listarReservas() {
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva reservaXID(int id) {
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReservas(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReservas(int id) {
		iReservaDAO.deleteById(id);
	}

}
