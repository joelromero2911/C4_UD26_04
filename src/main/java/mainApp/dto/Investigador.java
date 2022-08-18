package mainApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigador {

	@Id
	@Column(name = "dni")
	private String dni;
	@Column(name = "nom_apels")
	private String nom_apels;

	@ManyToOne
	@JoinColumn(name="facultad")
	Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="dni")
	private List<Reserva> reserva;

	/**
	 * 
	 */
	public Investigador() {
	}

	/**
	 * @param dni
	 * @param nom_apels
	 * @param facultad
	 * @param reserva
	 */
	public Investigador(String dni, String nom_apels, Facultad facultad, List<Reserva> reserva) {
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nom_apels
	 */
	public String getNom_apels() {
		return nom_apels;
	}

	/**
	 * @param nom_apels the nom_apels to set
	 */
	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
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
		return "Investigador [dni=" + dni + ", nom_apels=" + nom_apels + ", facultad=" + facultad + "]";
	}
	
}
