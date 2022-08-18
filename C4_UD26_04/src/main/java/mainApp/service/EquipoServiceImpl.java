package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IEquipoDAO;
import mainApp.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	IEquipoDAO iEquipoDAO;
	
	@Override
	public List<Equipo> listarEquipos() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipo equipoXID(String num_serie) {
		return iEquipoDAO.findById(num_serie).get();
	}

	@Override
	public Equipo actualizarEquipos(Equipo equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipos(String num_serie) {
		iEquipoDAO.deleteById(num_serie);
	}

}
