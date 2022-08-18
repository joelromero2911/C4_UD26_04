package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Integer>{

}
