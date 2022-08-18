package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Investigador;
import mainApp.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorXID(@PathVariable(name="dni") String dni) {
		
		Investigador investigador_xid= new Investigador();
		investigador_xid=investigadorServiceImpl.investigadorXID(dni);
		System.out.println("Investigador XID: "+investigador_xid);
		return investigador_xid;
	}

	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigadores(@PathVariable(name="dni")String dni,@RequestBody Investigador investigador) {
		
		Investigador investigador_seleccionado= new Investigador();
		Investigador investigador_actualizado= new Investigador();
		
		investigador_seleccionado= investigadorServiceImpl.investigadorXID(dni);
		investigador_seleccionado.setNom_apels(investigador.getNom_apels());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		investigador_actualizado = investigadorServiceImpl.actualizarInvestigadores(investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: "+ investigador_actualizado);
		
		return investigador_actualizado;
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public void eliminarInvestigadores(@PathVariable(name="dni")String dni) {
		investigadorServiceImpl.eliminarInvestigadores(dni);
	}
}
