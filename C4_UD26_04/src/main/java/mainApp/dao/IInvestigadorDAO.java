package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Investigador;

public interface IInvestigadorDAO extends JpaRepository<Investigador, String>{

}
