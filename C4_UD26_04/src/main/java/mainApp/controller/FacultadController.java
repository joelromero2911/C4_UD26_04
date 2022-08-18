package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Facultad;
import mainApp.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultades(){
		return facultadServiceImpl.listarFacultades();
	}
	
	@PostMapping("/facultades")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad facultadXID(@PathVariable(name="codigo") int codigo) {
		
		Facultad facultad_xid= new Facultad();
		facultad_xid=facultadServiceImpl.facultadXID(codigo);
		System.out.println("Facultad XID: "+facultad_xid);
		return facultad_xid;
	}

	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultades(@PathVariable(name="codigo")int codigo,@RequestBody Facultad facultad) {
		
		Facultad facultad_seleccionado= new Facultad();
		Facultad facultad_actualizado= new Facultad();
		
		facultad_seleccionado= facultadServiceImpl.facultadXID(codigo);
		facultad_seleccionado.setNombre(facultad.getNombre());
		facultad_actualizado = facultadServiceImpl.actualizarFacultades(facultad_seleccionado);
		
		System.out.println("La Facultad actualizada es: "+ facultad_actualizado);
		
		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{codigo}")
	public void eliminarFacultades(@PathVariable(name="codigo")int codigo) {
		facultadServiceImpl.eliminarFacultades(codigo);
	}
}
