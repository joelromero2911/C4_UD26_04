package mainApp.dto;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="investigadores")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="dni")
	Investigador investigador;
	
	@ManyToOne
	@JoinColumn(name="num_serie")
	Equipo equipo;
	
	@Column(name = "comienzo")
	private Date comienzo;
	@Column(name = "fin")
	private Date fin;
	/**
	 * 
	 */
	public Reserva() {
	}
	/**
	 * @param id
	 * @param investigador
	 * @param equipo
	 * @param comienzo
	 * @param fin
	 */
	public Reserva(int id, Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the investigador
	 */
	public Investigador getInvestigador() {
		return investigador;
	}
	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	/**
	 * @return the equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}
	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	/**
	 * @return the comienzo
	 */
	public Date getComienzo() {
		return comienzo;
	}
	/**
	 * @param comienzo the comienzo to set
	 */
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}
	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}
	
}
