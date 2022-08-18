package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Facultad;

public interface IFacultadDAO extends JpaRepository<Facultad, Integer>{

}
