package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Equipo;
import mainApp.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{num_serie}")
	public Equipo equipoXID(@PathVariable(name="num_serie") String num_serie) {
		
		Equipo equipo_xid= new Equipo();
		equipo_xid=equipoServiceImpl.equipoXID(num_serie);
		System.out.println("Equipo XID: "+equipo_xid);
		return equipo_xid;
	}

	@PutMapping("/equipos/{num_serie}")
	public Equipo actualizarEquipos(@PathVariable(name="num_serie")String num_serie,@RequestBody Equipo equipo) {
		
		Equipo equipo_seleccionado= new Equipo();
		Equipo equipo_actualizado= new Equipo();
		
		equipo_seleccionado= equipoServiceImpl.equipoXID(num_serie);
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		equipo_actualizado = equipoServiceImpl.actualizarEquipos(equipo_seleccionado);
		
		System.out.println("El Equipo actualizado es: "+ equipo_actualizado);
		
		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{num_serie}")
	public void eliminarEquipos(@PathVariable(name="num_serie")String num_serie) {
		equipoServiceImpl.eliminarEquipos(num_serie);
	}
}
