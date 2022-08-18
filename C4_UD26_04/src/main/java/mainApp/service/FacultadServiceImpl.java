package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IFacultadDAO;
import mainApp.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService{

	@Autowired
	IFacultadDAO iFacultadDAO;
	
	@Override
	public List<Facultad> listarFacultades() {
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(int codigo) {
		return iFacultadDAO.findById(codigo).get();
	}

	@Override
	public Facultad actualizarFacultades(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultades(int codigo) {
		iFacultadDAO.deleteById(codigo);
	}

}
