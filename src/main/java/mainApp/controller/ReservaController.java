package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Reserva;
import mainApp.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva reservaXID(@PathVariable(name="id") int id) {
		
		Reserva reserva_xid= new Reserva();
		reserva_xid=reservaServiceImpl.reservaXID(id);
		System.out.println("Reserva XID: "+reserva_xid);
		return reserva_xid;
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReservas(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionado= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionado= reservaServiceImpl.reservaXID(id);
		reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());
		reserva_actualizado = reservaServiceImpl.actualizarReservas(reserva_seleccionado);
		
		System.out.println("La Reserva actualizada es: "+ reserva_actualizado);
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eliminarReservas(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminarReservas(id);
	}
}
