package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, String>{

}
