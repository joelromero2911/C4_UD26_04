package mainApp.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultades")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name="facultad")
	private List<Investigador> investigador;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Equipo> equipo;

	/**
	 * 
	 */
	public Facultad() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param investigador
	 * @param equipo
	 */
	public Facultad(int codigo, String nombre, List<Investigador> investigador, List<Equipo> equipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigador = investigador;
		this.equipo = equipo;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the investigador
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	/**
	 * @return the equipo
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
