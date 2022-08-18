package mainApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Equipo {

	@Id
	@Column(name = "num_serie")
	private String num_serie;
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="facultad")
	Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="num_serie")
	private List<Reserva> reserva;

	/**
	 * 
	 */
	public Equipo() {
	}

	/**
	 * @param num_serie
	 * @param nombre
	 * @param facultad
	 * @param reserva
	 */
	public Equipo(String num_serie, String nombre, Facultad facultad, List<Reserva> reserva) {
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	/**
	 * @return the num_serie
	 */
	public String getNum_serie() {
		return num_serie;
	}

	/**
	 * @param num_serie the num_serie to set
	 */
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Equipo [num_serie=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
	
	
}
